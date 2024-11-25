package com.connectech.app.repository

import com.cs407.connectech.model.User
import com.cs407.connectech.network.ApiService
import com.cs407.connectech.network.requests.LoginRequest
import com.cs407.connectech.network.requests.RegisterRequest
import com.cs407.connectech.network.requests.ResetPasswordRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.lang.Exception

class AuthRepository(private val apiService: ApiService) {

    suspend fun login(email: String, password: String): Result<User> {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<User> = apiService.login(LoginRequest(email, password))
                if (response.isSuccessful) {
                    Result.success(response.body()!!)
                } else {
                    Result.failure(Exception("Login failed: ${response.message()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    suspend fun register(email: String, password: String): Result<User> {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<User> = apiService.register(RegisterRequest(email, password))
                if (response.isSuccessful) {
                    Result.success(response.body()!!)
                } else {
                    Result.failure(Exception("Registration failed: ${response.message()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    suspend fun resetPassword(email: String): Result<Void?> {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<Void> = apiService.resetPassword(ResetPasswordRequest(email))
                if (response.isSuccessful) {
                    Result.success(response.body())
                } else {
                    Result.failure(Exception("Password reset failed: ${response.message()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}
=======
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * AuthRepository: Manages user authentication and session data.
 *
 * Variables:
 * - _isAuthenticated: Internal MutableLiveData tracking the user's authentication state.
 * - isAuthenticated: Public LiveData exposing authentication state to observe in ViewModels.
 * - loggedInUser: Stores the username of the currently logged-in user.
 */
class AuthRepository {

    private val _isAuthenticated = MutableLiveData<Boolean>() // Tracks authentication state
    val isAuthenticated: LiveData<Boolean> get() = _isAuthenticated // Public observer for authentication state

    private var loggedInUser: String? = null // Stores the username of the logged-in user

    /**
     * Simulates user login.
     * @param username User's username.
     * @param password User's password.
     * @return True if authentication is successful, false otherwise.
     */
    fun login(username: String, password: String): Boolean {
        // Mock authentication logic
        if (username == "testUser" && password == "testPassword") {
            loggedInUser = username
            _isAuthenticated.value = true
            return true
        }
        _isAuthenticated.value = false
        return false
    }

    /**
     * Logs the user out and clears session data.
     */
    fun logout() {
        loggedInUser = null
        _isAuthenticated.value = false
    }

    /**
     * Returns the logged-in user.
     */
    fun getLoggedInUser(): String? {
        return loggedInUser
    }
}
