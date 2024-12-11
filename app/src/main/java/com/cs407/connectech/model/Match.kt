//Description: This file defines the structure for a match entity, used to represent the connection between a problem and a tech provider.
//
//Variables:
//providerId: ID of the matched tech provider (String).
//problemId: ID of the problem for which the match is made (String).
//score: The calculated match score based on the matching algorithm (Double).

//How to Use: The matching team can extend this file if more fields are required, such as feedback or acceptance status.

//package com.cs407.connectech.model
//
//data class Match(
//    val id: String,
//    val name: String,
//    val rating: Double,
//    val category: String,
//    val location: String
//)

package com.cs407.connectech.model

data class Match(
    val id: Int,
    val name: String,
    val rating: Double,
    val city: String,
    val category: String,
    val location: String,
    val email: String,          // Added field
    val phone: String,          // Added field
    val description: String     // Added field
)


