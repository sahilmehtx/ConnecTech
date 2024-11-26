package com.cs407.connectech.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cs407.connectech.databinding.FragmentSettingsBinding
import com.cs407.connectech.ui.login.LoginActivity

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        setupUI()
        return binding.root
    }

    private fun setupUI() {
        // Mock user data (replace with actual data as needed)
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
        // Logic to handle logout
        Toast.makeText(requireContext(), "Logged out successfully", Toast.LENGTH_SHORT).show()
        // Redirect to the login activity
        val intent = Intent(requireContext(), LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
