package com.cs407.connectech.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cs407.connectech.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 * Fake implementation of AuthRepository using hardcoded data for testing.
 */
class FakeAuthRepository : AuthRepository {

    private val _isAuthenticated = MutableLiveData<Boolean>()
    val isAuthenticated: LiveData<Boolean> get() = _isAuthenticated
    private var loggedInUser: String? = null

    // List of valid emails for login
    private val validEmails = listOf(
        "test@example.com",
        "harsh.com",
        "sahil.com",
        "srijan.com",
        "tanmay.com"
    )

    /**
     * Simulates user login with hardcoded credentials.
     */
    override suspend fun login(email: String, password: String): Result<User> {
        return withContext(Dispatchers.IO) {
            try {
                // Simulate network delay
                delay(1000)

                // Hardcoded valid password
                val validPassword = "123"

                // Check if email and password are valid
                if (email in validEmails && password == validPassword) {
                    val user = User(
                        id = validEmails.indexOf(email) + 1, // Generate ID based on email index
                        name = "User ${validEmails.indexOf(email) + 1}",
                        email = email,
                        role = "user"
                    )
                    loggedInUser = user.email
                    _isAuthenticated.postValue(true)
                    Result.success(user)
                } else {
                    Result.failure(Exception("Invalid email or password"))
                }
            } catch (e: Exception) {
                _isAuthenticated.postValue(false)
                Result.failure(e)
            }
        }
    }

    /**
     * Simulates user registration with hardcoded data.
     */
    override suspend fun register(email: String, password: String): Result<User> {
        return withContext(Dispatchers.IO) {
            try {
                // Simulate network delay
                delay(1000)

                // Simple validation
                if (email.contains("@") && password.length >= 6) {
                    val user = User(
                        id = validEmails.size + 1,
                        name = "New User",
                        email = email,
                        role = "user"
                    )
                    Result.success(user)
                } else {
                    Result.failure(Exception("Invalid email or password format"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    /**
     * Simulates password reset with hardcoded response.
     */
    override suspend fun resetPassword(email: String): Result<Void?> {
        return withContext(Dispatchers.IO) {
            try {
                // Simulate network delay
                delay(1000)

                if (email.contains("@")) {
                    // Assume password reset email sent successfully
                    Result.success(null)
                } else {
                    Result.failure(Exception("Invalid email format"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    /**
     * Simulates problem submission with hardcoded response.
     */
    override suspend fun submitProblem(problemDetails: String, category: String): Result<Boolean> {
        return withContext(Dispatchers.IO) {
            try {
                // Simulate network delay
                delay(1000)

                if (problemDetails.isNotEmpty() && category.isNotEmpty()) {
                    // Assume problem submission is successful
                    Result.success(true)
                } else {
                    Result.failure(Exception("Problem details or category cannot be empty"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    /**
     * Logs the user out and clears session data.
     */
    override fun logout() {
        loggedInUser = null
        _isAuthenticated.value = false
    }

    /**
     * Returns the logged-in user's email.
     */
    override fun getLoggedInUser(): String? {
        return loggedInUser
    }
}
