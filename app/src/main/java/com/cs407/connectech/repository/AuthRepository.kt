package com.connectech.app.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cs407.connectech.model.Match
import com.cs407.connectech.model.User
import com.cs407.connectech.network.ApiService
import com.cs407.connectech.network.requests.LoginRequest
import com.cs407.connectech.network.requests.RegisterRequest
import com.cs407.connectech.network.requests.ResetPasswordRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.lang.Exception
import com.cs407.connectech.network.requests.SubmitProblemRequest

/**
 * AuthRepository: Manages user authentication, session data, and API calls.
 */
class AuthRepository(private val apiService: ApiService) {

    private val _isAuthenticated = MutableLiveData<Boolean>()
    val isAuthenticated: LiveData<Boolean> get() = _isAuthenticated
    private var loggedInUser: String? = null

    /**
     * Handles user login using the API.
     */
    suspend fun login(email: String, password: String): Result<User> {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<User> = apiService.login(LoginRequest(email, password))
                if (response.isSuccessful) {
                    response.body()?.let { user ->
                        loggedInUser = user.email
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

    suspend fun submitProblem(problemDetails: String, category: String): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response =
                    apiService.submitProblem(SubmitProblemRequest(problemDetails, category))
                if (response.isSuccessful) {
                    true
                } else {
                    throw Exception("Problem submission failed: ${response.message()}")
                }
            } catch (e: Exception) {
                throw Exception("Error during problem submission: ${e.message}")
            }
        }
    }

    /**
     * Handles user registration using the API.
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
     * Fetches the best matches for the user.
     */
    suspend fun getBestMatches(): List<Match> {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<List<Match>> = apiService.fetchBestMatches()
                if (response.isSuccessful) {
                    response.body() ?: emptyList()
                } else {
                    throw Exception("Failed to fetch matches: ${response.message()}")
                }
            } catch (e: Exception) {
                throw Exception("Error fetching matches: ${e.message}")
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
     */
    fun getLoggedInUser(): String? {
        return loggedInUser
    }
}
