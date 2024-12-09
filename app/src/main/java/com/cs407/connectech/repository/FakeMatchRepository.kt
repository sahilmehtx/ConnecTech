// File: FakeMatchRepository.kt
package com.cs407.connectech.repository

import com.cs407.connectech.model.Match
//import javax.inject.Inject

class FakeMatchRepository{
    fun getBestMatches(tag: String): List<Match> {
        // Simulated data based on the tag
        return when (tag) {
            "AI/ML" -> listOf(
                Match(
                    1, "AI Corp", 4.5, "New York",
                    location = TODO(),
                    email = TODO(),
                    phone = TODO(),
                    description = TODO()
                ),
                Match(
                    2, "Machine Learning Inc.", 4.7, "San Francisco",
                    location = TODO(),
                    email = TODO(),
                    phone = TODO(),
                    description = TODO()
                )
            )
            "Data Science" -> listOf(
                Match(
                    3, "Data Solutions", 4.6, "Chicago",
                    location = TODO(),
                    email = TODO(),
                    phone = TODO(),
                    description = TODO()
                ),
                Match(
                    4, "Analytics LLC", 4.8, "Boston",
                    location = TODO(),
                    email = TODO(),
                    phone = TODO(),
                    description = TODO()
                )
            )
            // Add more cases as needed
            else -> emptyList()
        }
    }
}
