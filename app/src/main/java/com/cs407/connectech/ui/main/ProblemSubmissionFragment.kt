package com.cs407.connectech.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cs407.connectech.auth.AuthViewModel
import com.cs407.connectech.databinding.FragmentProblemSubmissionBinding
import com.cs407.connectech.viewmodel.AuthViewModel  // Existing ViewModel to use for lifecycle management

class ProblemSubmissionFragment : Fragment() {

    private var _binding: FragmentProblemSubmissionBinding? = null
    private val binding get() = _binding!!
    private lateinit var authViewModel: AuthViewModel  // Reuse `AuthViewModel` to manage data operations

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProblemSubmissionBinding.inflate(inflater, container, false)

        // Initialize ViewModel
        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        setupUI()
        return binding.root
    }

    private fun setupUI() {
        // Set up the "Submit" button click listener
        binding.submitButton.setOnClickListener {
            val projectDetails = binding.projectDetailsInput.text.toString()  // Retrieve project details from input
            val category = binding.categoryDropdown.selectedItem.toString()   // Get selected category from dropdown

            // Check if inputs are valid
            if (projectDetails.isNotBlank() && category.isNotEmpty()) {
                // Call ViewModel function to submit problem
                // **Function Needed in AuthViewModel**: `submitProblem(projectDetails: String, category: String)`
                // **Integrates With**: `ProblemRepository` to send data to backend
                // **Expected Outcome**: This function should send project details to backend for saving
                authViewModel.submitProblem(projectDetails, category)

                // Display success message
                Toast.makeText(context, "Problem submitted successfully!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Please fill in all required fields.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
