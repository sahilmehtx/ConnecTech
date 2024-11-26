package com.cs407.connectech.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cs407.connectech.databinding.FragmentLoginBinding
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import com.connectech.app.repository.AuthRepository
import com.cs407.connectech.network.ApiService
import com.cs407.connectech.network.MockInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var authRepository: AuthRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize ApiService and AuthRepository
        val apiService = provideApiService()
        authRepository = AuthRepository(apiService)

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
        // Launch a coroutine in the lifecycle scope of the activity
        lifecycleScope.launch {
            try {
                // Show a loading indicator if you have one
                val result = authRepository.login(email, password)
                if (result.isSuccess) {
                    // Login successful
                    Toast.makeText(this@LoginActivity, "Login successful", Toast.LENGTH_SHORT).show()

                    // Navigate to the main activity or dashboard
                    // val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    // startActivity(intent)
                    // finish()
                } else {
                    // Login failed
                    val exception = result.exceptionOrNull()
                    Toast.makeText(
                        this@LoginActivity,
                        "Login failed: ${exception?.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } catch (e: Exception) {
                // Handle any exceptions
                Toast.makeText(this@LoginActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            } finally {
                // Hide the loading indicator if you have one
            }
        }
    }

    // Helper method to provide an instance of ApiService
    private fun provideApiService(): ApiService {
        val mockInterceptor = MockInterceptor()

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(mockInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://mock-api.com/") // Base URL is irrelevant here
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiService::class.java)
    }
}
