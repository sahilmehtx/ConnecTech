package com.cs407.connectech.network.requests

data class ResetPasswordRequest(
    val email: String
)
data class RegisterRequest(
    val email: String,
    val password: String
)

