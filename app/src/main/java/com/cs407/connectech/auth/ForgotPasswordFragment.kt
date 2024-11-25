package com.cs407.connectech.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.cs407.connectech.databinding.FragmentForgotPasswordBinding
import com.cs407.connectech.auth.AuthViewModel

class ForgotPasswordFragment : Fragment() {
    private lateinit var binding: FragmentForgotPasswordBinding
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        setupListeners()
        observeViewModel()
        return binding.root
    }

    private fun setupListeners() {
        binding.resetPasswordButton.setOnClickListener {
            val email = binding.emailEditText.text.toString().trim()
            if (email.isNotEmpty()) {
                authViewModel.resetPassword(email)
            } else {
                Toast.makeText(context, "Please enter your email", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun observeViewModel() {
        authViewModel.resetPasswordResult.observe(viewLifecycleOwner) { result ->
            result.onSuccess {
                Toast.makeText(context, "Reset link sent to email", Toast.LENGTH_SHORT).show()
            }.onFailure {
                Toast.makeText(context, it.message ?: "Reset failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
