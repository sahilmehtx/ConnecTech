// File: ProblemSubmissionFragment.kt
package com.cs407.connectech.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cs407.connectech.R
import com.cs407.connectech.databinding.FragmentProblemSubmissionBinding
import com.cs407.connectech.viewmodel.AuthViewModel
import com.cs407.connectech.viewmodel.AuthViewModelFactory
import com.cs407.connectech.repository.FakeAuthRepository
//import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class ProblemSubmissionFragment : Fragment() {

    private var _binding: FragmentProblemSubmissionBinding? = null
    private val binding get() = _binding!!
    private lateinit var authViewModel: AuthViewModel  // Reuse AuthViewModel to manage data operations

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentProblemSubmissionBinding.inflate(inflater, container, false)

        // Initialize FakeAuthRepository
        val fakeAuthRepository = FakeAuthRepository()

        // Initialize ViewModel with Factory
        val factory = AuthViewModelFactory(fakeAuthRepository)
        authViewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)

        setupUI()
        observeSubmissionResult()

        return binding.root
    }

    private fun setupUI() {
        // 1. Populate the Spinner (categoryDropdown) with predefined categories
        val categories = listOf("AI/ML", "Data Science", "Web Development", "Mobile Development")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.categoryDropdown.adapter = adapter

        // 2. Set a default selection to avoid null selectedItem
        if (categories.isNotEmpty()) {
            binding.categoryDropdown.setSelection(0)
        }

        // 3. Set up the "Analyze and Match" button click listener
        binding.submitButton.setOnClickListener {
            // Retrieve and trim inputs safely using safe calls and Elvis operator
            val problemDetails = binding.projectDetailsInput.text?.toString()?.trim() ?: ""
            val category = binding.categoryDropdown.selectedItem?.toString()?.trim() ?: ""

            // Retrieve selected chip safely
            val selectedChipId = binding.tagChipGroup.checkedChipId
            val selectedTag = if (selectedChipId != View.NO_ID) {
                binding.tagChipGroup.findViewById<com.google.android.material.chip.Chip>(selectedChipId)?.text?.toString()?.trim() ?: ""
            } else {
                ""
            }

            // Log the retrieved values for debugging purposes
            Log.d("ProblemSubmission", "Problem Details: '$problemDetails', Category: '$category', Selected Tag: '$selectedTag'")

            // Validate inputs and provide specific feedback
            when {
                problemDetails.isEmpty() -> {
                    binding.projectDetailsInput.error = "Please enter project details."
                }
                category.isEmpty() -> {
                    Toast.makeText(context, "Please select a category.", Toast.LENGTH_SHORT).show()
                }
                selectedTag.isEmpty() -> {
                    Toast.makeText(context, "Please select a tag.", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    // All inputs are valid; proceed with submission
                    submitProblem(problemDetails, category, selectedTag)
                }
            }
        }
    }

    private fun submitProblem(problemDetails: String, category: String, selectedTag: String) {
        // Show ProgressBar (Optional)
        binding.progressBar.visibility = View.VISIBLE

        // Disable the submit button to prevent multiple submissions
        binding.submitButton.isEnabled = false

        // Submit the problem via ViewModel
        authViewModel.submitProblem(problemDetails, category)

        // Observe the submission result
        authViewModel.problemSubmissionResult.observe(viewLifecycleOwner) { result ->
            // Re-enable the submit button and hide the ProgressBar
            binding.submitButton.isEnabled = true
            binding.progressBar.visibility = View.GONE

            result.onSuccess {
                // Navigate to BestMatchesFragment with the selected tag using Safe Args
                val action = ProblemSubmissionFragmentDirections.actionProblemSubmissionFragmentToBestMatchesFragment(selectedTag)
                findNavController().navigate(action)

                // Provide user feedback
                Toast.makeText(context, "Problem submitted successfully!", Toast.LENGTH_SHORT).show()
            }.onFailure { exception: Throwable ->
                // Handle submission failure gracefully
                Toast.makeText(context, "Submission failed: ${exception.message}", Toast.LENGTH_SHORT).show()
                Log.e("ProblemSubmission", "Submission failed: ${exception.message}")
            }
        }
    }

    private fun observeSubmissionResult() {
        // This method is now redundant as observation is handled in submitProblem
        // You can remove or repurpose it if needed
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
