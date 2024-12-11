// File: LoginFragment.kt
package com.cs407.connectech.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cs407.connectech.R
import com.cs407.connectech.databinding.FragmentLoginBinding
import com.cs407.connectech.viewmodel.AuthViewModel
import com.cs407.connectech.viewmodel.AuthViewModelFactory
import com.cs407.connectech.repository.FakeAuthRepository

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var authViewModel: AuthViewModel
    private lateinit var authViewModelFactory: AuthViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        // Initialize FakeAuthRepository
        val fakeAuthRepository = FakeAuthRepository()

        // Initialize ViewModel with Factory
        authViewModelFactory = AuthViewModelFactory(fakeAuthRepository)
        authViewModel = ViewModelProvider(this, authViewModelFactory).get(AuthViewModel::class.java)

        setupListeners()
        observeLoginResult()

        return binding.root
    }

    private fun setupListeners() {
        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                authViewModel.login(email, password)
            } else {
                Toast.makeText(context, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }


        binding.forgotPasswordTextView.setOnClickListener {
            // Navigate to ForgotPasswordFragment
            findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        }
    }

    private fun observeLoginResult() {
        authViewModel.loginResult.observe(viewLifecycleOwner) { result ->
            result.onSuccess {
                Toast.makeText(context, "Login successful!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_loginFragment_to_problemSubmissionFragment)
            }.onFailure {
                Toast.makeText(context, "Login failed: ${it.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
