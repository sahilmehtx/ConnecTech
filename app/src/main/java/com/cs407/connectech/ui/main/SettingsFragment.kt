// File: SettingsFragment.kt
package com.cs407.connectech.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cs407.connectech.R
import com.cs407.connectech.databinding.FragmentSettingsBinding
import com.cs407.connectech.viewmodel.AuthViewModel
import com.cs407.connectech.viewmodel.AuthViewModelFactory
import com.cs407.connectech.repository.FakeAuthRepository

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    // Initialize AuthViewModel
    private lateinit var authViewModel: AuthViewModel
    private lateinit var authViewModelFactory: AuthViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)

        // Initialize FakeAuthRepository
        val fakeAuthRepository = FakeAuthRepository()

        // Initialize AuthViewModel with Factory
        authViewModelFactory = AuthViewModelFactory(fakeAuthRepository)
        authViewModel = ViewModelProvider(this, authViewModelFactory).get(AuthViewModel::class.java)

        setupUI()
        observeLogoutResult()

        return binding.root
    }

    private fun setupUI() {
        // Set up the UI with mock data or leave empty if not required
        binding.etName.setText("John Doe")
        binding.etEmail.setText("john.doe@example.com")

        // Handle button clicks
        binding.btnOngoingContract.setOnClickListener {
            Toast.makeText(requireContext(), "Ongoing Contract Clicked", Toast.LENGTH_SHORT).show()
        }

        binding.btnPreviousContract.setOnClickListener {
            Toast.makeText(requireContext(), "Previous Contract Clicked", Toast.LENGTH_SHORT).show()
        }

        binding.btnScannedDocuments.setOnClickListener {
            Toast.makeText(requireContext(), "Scanned Documents Clicked", Toast.LENGTH_SHORT).show()
        }

        binding.btnProgress.setOnClickListener {
            Toast.makeText(requireContext(), "Progress Clicked", Toast.LENGTH_SHORT).show()
        }

        binding.btnHelpCenter.setOnClickListener {
            Toast.makeText(requireContext(), "Help Center Clicked", Toast.LENGTH_SHORT).show()
        }

        binding.btnLogout.setOnClickListener {
            handleLogout()
        }
    }

    private fun handleLogout() {
        // Perform logout via ViewModel
        authViewModel.logout()

        // Display logout success message
        Toast.makeText(requireContext(), "Logged out successfully", Toast.LENGTH_SHORT).show()

        // Navigate to LoginFragment using the defined navigation action
        findNavController().navigate(R.id.action_settingsFragment_to_loginFragment)
    }

    private fun observeLogoutResult() {
        // Optional: Observe any LiveData related to logout if implemented
        // Currently, logout is handled synchronously in handleLogout()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
