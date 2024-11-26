package com.cs407.connectech.repository

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
