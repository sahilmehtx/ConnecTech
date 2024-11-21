package com.cs407.connectech.network

import com.cs407.connectech.model.User
import com.cs407.connectech.network.requests.LoginRequest
import com.cs407.connectech.network.requests.RegisterRequest
import com.cs407.connectech.network.requests.ResetPasswordRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("/auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<User>

    @POST("/auth/register")
    suspend fun register(@Body registerRequest: RegisterRequest): Response<User>

    @POST("/auth/resetPassword")
    suspend fun resetPassword(@Body request: ResetPasswordRequest): Response<Void>

}