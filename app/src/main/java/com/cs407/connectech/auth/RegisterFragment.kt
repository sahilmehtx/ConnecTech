package com.cs407.connectech.auth

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cs407.connectech.R
import com.cs407.connectech.databinding.FragmentRegisterBinding
import com.cs407.connectech.repository.FakeAuthRepository
import com.cs407.connectech.viewmodel.AuthViewModel
import com.cs407.connectech.viewmodel.AuthViewModelFactory

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private lateinit var authViewModel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)

        // Initialize FakeAuthRepository
        val fakeAuthRepository = FakeAuthRepository()

        // Initialize ViewModel with Factory
        val authViewModelFactory = AuthViewModelFactory(fakeAuthRepository)
        authViewModel = ViewModelProvider(this, authViewModelFactory).get(AuthViewModel::class.java)

        setupListeners()

        return binding.root
    }

    private fun setupListeners() {
        binding.magicButton.setOnClickListener {
            val email = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()
            val confirmPassword = binding.confirmPasswordEditText.text.toString().trim()

            when {
                email.isEmpty() -> {
                    binding.emailEditText.error = "Please enter your email"
                }
                password.isEmpty() -> {
                    binding.passwordEditText.error = "Please enter a password"
                }
                confirmPassword.isEmpty() -> {
                    binding.confirmPasswordEditText.error = "Please confirm your password"
                }
                password != confirmPassword -> {
                    Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    authViewModel.register(email, password).observe(viewLifecycleOwner) { result ->
                        result.onSuccess {
                            showSuccessDialog()
                        }.onFailure {
                            Toast.makeText(context, "Registration failed: ${it.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }

    private fun showSuccessDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Registration Success")
            .setMessage("Account Successfully Registered")
            .setPositiveButton("OK") { _, _ ->
                findNavController().navigate(R.id.action_registerFragment_to_problemSubmissionFragment)
            }
            .setCancelable(false)
            .show()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
