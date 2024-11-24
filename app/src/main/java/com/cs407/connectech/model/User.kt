//Description: This file represents the user entity, storing information about users, including their roles and ratings.
//
//Variables:
//id: Unique identifier for the user (String).
//name: Name of the user (String).
//email: Email address of the user (String).
//role: Role of the user (e.g., "Business", "Tech Provider") (String).
//rating: Nullable field representing the user’s rating (Float).
//How to Use: Backend developers can extend this to include more user-related fields like profile picture or bio. Frontend developers can use it to display user details on profile screens.

package com.cs407.connectech.model

data class User(
    val id: String,
    val name: String,
    val email: String,
    val role: String, // e.g., "Business", "Tech Provider"
    val rating: Float? = null // Nullable for non-tech providers
)
