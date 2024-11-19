package com.connectech.app.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * MatchRepository: Manages business-to-tech provider matching logic.
 *
 * Variables:
 * - _matches: Internal MutableLiveData holding matching results for a project.
 * - matches: Public LiveData exposing match results for observing in ViewModels.
 * - mockMatches: A mock dataset containing predefined matches for projects.
 */
class MatchRepository {

    private val _matches = MutableLiveData<List<String>>() // Tracks matching results for a project
    val matches: LiveData<List<String>> get() = _matches // Public observer for matching results

    // Mock match data
    private val mockMatches = mapOf(
        "Project A" to listOf("Tech Partner 1", "Tech Partner 2"),
        "Project B" to listOf("Tech Partner 3", "Tech Partner 4"),
        "Project C" to listOf("Tech Partner 5", "Tech Partner 6")
    )

    /**
     * Finds matches for a given project.
     * @param projectId The ID of the project.
     */
    fun findMatches(projectId: String) {
        _matches.value = mockMatches[projectId] ?: emptyList()
    }
}

