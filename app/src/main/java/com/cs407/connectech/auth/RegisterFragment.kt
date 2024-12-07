//package com.cs407.connectech.auth
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.viewModels
//import com.cs407.connectech.databinding.FragmentRegisterBinding
//import com.cs407.connectech.auth.AuthViewModel
//
//class RegisterFragment : Fragment() {
//    private lateinit var binding: FragmentRegisterBinding
//    private val authViewModel: AuthViewModel by viewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        binding = FragmentRegisterBinding.inflate(inflater, container, false)
//        setupListeners()
//        observeViewModel()
//        return binding.root
//    }
//
//    private fun setupListeners() {
//        binding.registerButton.setOnClickListener {
//            val email = binding.emailEditText.text.toString().trim()
//            val password = binding.passwordEditText.text.toString().trim()
//            val confirmPassword = binding.confirmPasswordEditText.text.toString().trim()
//
//            if (email.isNotEmpty() && password.isNotEmpty() && password == confirmPassword) {
//                authViewModel.register(email, password)
//            } else if (password != confirmPassword) {
//                Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(context, "Please fill out all fields", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//
//    private fun observeViewModel() {
//        authViewModel.registerResult.observe(viewLifecycleOwner) { result ->
//            result.onSuccess {
//                Toast.makeText(context, "Registration successful", Toast.LENGTH_SHORT).show()
//            }.onFailure {
//                Toast.makeText(context, it.message ?: "Registration failed", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//}

package com.cs407.connectech.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cs407.connectech.R
import com.cs407.connectech.databinding.FragmentRegisterBinding
import com.cs407.connectech.ui.main.HomeFragment

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        setupListeners()
        return binding.root
    }

    private fun setupListeners() {
        binding.registerButton.setOnClickListener {
            val email = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()
            val confirmPassword = binding.confirmPasswordEditText.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty() && password == confirmPassword) {
                Toast.makeText(context, "Registration successful!", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }
        }

        // Navigate to HomeFragment when "Click to experience the magic" button is clicked
        binding.magicButton.setOnClickListener {
            navigateToHomeFragment()
        }
    }

    private fun navigateToHomeFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, HomeFragment())
            .addToBackStack(null)
            .commit()
    }
}
