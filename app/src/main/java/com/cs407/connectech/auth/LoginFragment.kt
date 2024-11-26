package com.cs407.connectech.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.cs407.connectech.databinding.FragmentLoginBinding
import AuthViewModel
import androidx.lifecycle.ViewModelProvider
import com.connectech.app.repository.AuthRepository
import com.cs407.connectech.network.RetrofitClient

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    //private val authViewModel: AuthViewModel by viewModels()
    private lateinit var authViewModel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        // Obtain ApiService from RetrofitClient
        val apiService = RetrofitClient.apiService

        // Initialize AuthRepository
        val authRepository = AuthRepository(apiService)


        // Initialize ViewModel using the factory
        val factory = AuthViewModelFactory(authRepository)
        authViewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)
        setupListeners()
        observeViewModel()
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
    }

    private fun observeViewModel() {
        authViewModel.loginResult.observe(viewLifecycleOwner) { result ->
            result.onSuccess {
                Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
            }.onFailure {
                Toast.makeText(context, it.message ?: "Login failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}