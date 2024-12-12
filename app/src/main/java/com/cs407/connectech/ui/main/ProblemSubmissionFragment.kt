package com.cs407.connectech.ui.main

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.cs407.connectech.R
import com.cs407.connectech.data.AppDatabase
import com.cs407.connectech.databinding.FragmentProblemSubmissionBinding
import com.cs407.connectech.repository.FakeAuthRepository
import com.cs407.connectech.repository.FakeMatchRepository
import com.cs407.connectech.viewmodel.AuthViewModel
import com.cs407.connectech.viewmodel.AuthViewModelFactory
import com.cs407.connectech.viewmodel.MatchViewModel
import com.cs407.connectech.viewmodel.MatchViewModelFactory
import com.google.android.material.chip.Chip

class ProblemSubmissionFragment : Fragment() {

    private var _binding: FragmentProblemSubmissionBinding? = null
    private val binding get() = _binding!!
   private lateinit var authViewModel: AuthViewModel
   private lateinit var matchViewModel: MatchViewModel

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View {
        _binding = FragmentProblemSubmissionBinding.inflate(inflater, container, false)

        val db = Room.databaseBuilder(requireContext(), AppDatabase::class.java, "app_db").build()
        val authRepo = FakeAuthRepository(db.userDao())
        val factory = AuthViewModelFactory(authRepo)
        authViewModel = ViewModelProvider(this, factory)[AuthViewModel::class.java]
        matchViewModel = ViewModelProvider(this, MatchViewModelFactory(FakeMatchRepository(requireContext())))[MatchViewModel::class.java]

        setupUI()
        return binding.root
    }

    private fun setupUI() {
        val categories = listOf(
            "Large Business", "Medium Business", "Small Business", "Enterprise",
            "Private Project", "Startup", "Other", "None"
        )
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.categoryDropdown.adapter = adapter
        binding.categoryDropdown.setSelection(0)

        // Populate tags (industries) from companies.csv
        val repository = FakeMatchRepository(requireContext())
        val tags = repository.getAllCompanies()
            .map { it.industry }
            .distinct()

        tags.forEach { tagText ->
            val chip = Chip(requireContext())
            chip.text = tagText
            chip.isCheckable = true
            binding.tagChipGroup.addView(chip)
        }

        // Add tags as chips dynamically if needed, or ensure they are defined in the layout.
        // If your layout already has chips, skip adding them here.
        // Example:
        /*
        val tags = listOf("AI/ML", "Data Science", "Web Dev", "Mobile Dev", "Cloud Computing", "Blockchain", "Cybersecurity")
        tags.forEach { tagText ->
            val chip = Chip(requireContext())
            chip.text = tagText
            chip.isCheckable = true
            binding.tagChipGroup.addView(chip)
        }
        */

        binding.submitButton.setOnClickListener {
            val problemDetails = binding.projectDetailsInput.text?.toString()?.trim() ?: ""
            val category = binding.categoryDropdown.selectedItem?.toString()?.trim() ?: ""

            val selectedChipId = binding.tagChipGroup.checkedChipId
            val selectedTag = if (selectedChipId != View.NO_ID) {
                binding.tagChipGroup.findViewById<Chip>(selectedChipId)?.text?.toString()?.trim() ?: ""
            } else {
                ""
            }

            Log.d("ProblemSubmission", "Problem Details: '$problemDetails', Category: '$category', Selected Tag: '$selectedTag'")

            when {
                problemDetails.isEmpty() -> binding.projectDetailsInput.error = "Please enter project details."
                category.isEmpty() -> Toast.makeText(context, "Please select a category.", Toast.LENGTH_SHORT).show()
                selectedTag.isEmpty() -> Toast.makeText(context, "Please select a tag.", Toast.LENGTH_SHORT).show()
                else -> submitProblem(problemDetails, category, selectedTag)
            }
        }
    }

    private fun submitProblem(problemDetails: String, category: String, selectedTag: String) {
        binding.progressBar.visibility = View.VISIBLE
        binding.submitButton.isEnabled = false

        authViewModel.submitProblem(problemDetails, category)
        authViewModel.problemSubmissionResult.observe(viewLifecycleOwner) { result ->
            binding.submitButton.isEnabled = true
            binding.progressBar.visibility = View.GONE

            result.onSuccess {
                val action = ProblemSubmissionFragmentDirections.actionProblemSubmissionFragmentToBestMatchesFragment(selectedTag, category)
                findNavController().navigate(action)
                Toast.makeText(context, "Problem submitted successfully!", Toast.LENGTH_SHORT).show()
            }.onFailure { exception ->
                Toast.makeText(context, "Submission failed: ${exception.message}", Toast.LENGTH_SHORT).show()
                Log.e("ProblemSubmission", "Submission failed: ${exception.message}")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
