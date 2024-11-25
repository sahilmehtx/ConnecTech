package com.connectech.app.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cs407.connectech.model.User
import com.cs407.connectech.network.ApiService
import com.cs407.connectech.network.requests.LoginRequest
import com.cs407.connectech.network.requests.RegisterRequest
import com.cs407.connectech.network.requests.ResetPasswordRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.lang.Exception

/**
 * AuthRepository: Manages user authentication, session data, and API calls.
 *
 * Variables:
 * - _isAuthenticated: Internal MutableLiveData tracking the user's authentication state.
 * - isAuthenticated: Public LiveData exposing authentication state to observe in ViewModels.
 * - loggedInUser: Stores the username of the currently logged-in user.
 */
class AuthRepository(private val apiService: ApiService) {

    private val _isAuthenticated = MutableLiveData<Boolean>() // Tracks authentication state
    val isAuthenticated: LiveData<Boolean> get() = _isAuthenticated // Public observer for authentication state

    private var loggedInUser: String? = null // Stores the username of the logged-in user

    /**
     * Handles user login using the API.
     * @param email User's email.
     * @param password User's password.
     * @return A Result wrapping a User object on success or an error on failure.
     */
    suspend fun login(email: String, password: String): Result<User> {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<User> = apiService.login(LoginRequest(email, password))
                if (response.isSuccessful) {
                    response.body()?.let { user ->
                        loggedInUser = user.email // Update session data
                        _isAuthenticated.postValue(true)
                        Result.success(user)
                    } ?: Result.failure(Exception("Login response was null"))
                } else {
                    Result.failure(Exception("Login failed: ${response.message()}"))
                }
            } catch (e: Exception) {
                _isAuthenticated.postValue(false)
                Result.failure(e)
            }
        }
    }

    /**
     * Handles user registration using the API.
     * @param email User's email.
     * @param password User's password.
     * @return A Result wrapping a User object on success or an error on failure.
     */
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

    /**
     * Handles password reset using the API.
     * @param email User's email.
     * @return A Result wrapping a Void object on success or an error on failure.
     */
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

    /**
     * Logs the user out and clears session data.
     */
    fun logout() {
        loggedInUser = null
        _isAuthenticated.value = false
    }

    /**
     * Returns the logged-in user's email.
     * @return The email of the logged-in user, or null if no user is logged in.
     */
    fun getLoggedInUser(): String? {
        return loggedInUser
    }
}
