package com.cs407.connectech.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.cs407.connectech.MyApplication
import com.cs407.connectech.R
import com.cs407.connectech.data.AppDatabase
import com.cs407.connectech.databinding.FragmentRegisterBinding
import com.cs407.connectech.repository.FakeAuthRepository
import com.cs407.connectech.viewmodel.AuthViewModel
import com.cs407.connectech.viewmodel.AuthViewModelFactory

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var authViewModel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        // Get the shared database from the Application class
        val appDatabase = (requireContext().applicationContext as MyApplication).database
        val authRepo = FakeAuthRepository(appDatabase.userDao())
        val factory = AuthViewModelFactory(authRepo)
        authViewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)

        setupListeners()
        observeRegisterResult()

        return binding.root
    }

    private fun setupListeners() {
        binding.registerButton.setOnClickListener {
            val email = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()
            val confirmPassword = binding.confirmPasswordEditText.text.toString().trim()

            when {
                email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() ->
                    Toast.makeText(context, "Please fill out all fields", Toast.LENGTH_SHORT).show()
                password != confirmPassword ->
                    Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
                else -> authViewModel.register(email, password)
            }
        }

        // If you want the "magicButton" to also proceed after registration,
        // you could either remove this button or have it navigate somewhere relevant.
        // For demonstration, let's navigate to the loginFragment so user can log in immediately.
        binding.magicButton.setOnClickListener {
            // Navigate to LoginFragment (defined in nav_graph)
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }

    private fun observeRegisterResult() {
        authViewModel.registerResult.observe(viewLifecycleOwner) { result ->
            result.onSuccess {
                Toast.makeText(context, "Registration successful! User added to DB.", Toast.LENGTH_SHORT).show()
                // After successful registration, navigate user to login so they can log in
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }.onFailure { e ->
                Toast.makeText(context, "Registration failed: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
