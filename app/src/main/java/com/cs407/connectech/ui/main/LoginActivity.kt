package com.cs407.connectech.ui.login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cs407.connectech.databinding.FragmentLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {
        // Handle login button click
        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            } else {
                // Perform login logic
                performLogin(email, password)
            }
        }

        // Handle forgot password click
        binding.forgotPasswordTextView.setOnClickListener {
            Toast.makeText(this, "Forgot Password Clicked", Toast.LENGTH_SHORT).show()
            // Implement forgot password logic here
        }
    }

    private fun performLogin(email: String, password: String) {
        // TODO: Implement your login logic here (e.g., API call to authenticate)

        // For demonstration, show a success message
        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()

        // Navigate to the main activity or dashboard
        // val intent = Intent(this, MainActivity::class.java)
        // startActivity(intent)
        // finish()
    }
}
