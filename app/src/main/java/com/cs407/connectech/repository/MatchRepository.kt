package com.connectech.app.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cs407.connectech.network.ApiService

/**
 * MatchRepository: Manages business-to-tech provider matching logic.
 *
 * Variables:
 * - apiService: Instance of ApiService for API interactions.
 * - _matches: Internal MutableLiveData holding matching results for a project.
 * - matches: Public LiveData exposing match results for observing in ViewModels.
 */
class MatchRepository(private val apiService: ApiService) {

    private val _matches = MutableLiveData<List<String>>() // Tracks matching results for a project
    val matches: LiveData<List<String>> get() = _matches // Public observer for matching results

    /**
     * Finds matches for a given project by making an API call.
     * @param projectId The ID of the project.
     */
    suspend fun findMatches(projectId: String) {
        try {
            // Mocking the API response (Replace with actual API call logic)
            val response = apiService.fetchBestMatches() // Example usage
            if (response.isSuccessful) {
                _matches.postValue(response.body()?.map { it.toString() } ?: emptyList())
            } else {
                _matches.postValue(emptyList()) // Handle unsuccessful response
            }
        } catch (e: Exception) {
            _matches.postValue(emptyList()) // Handle exception
        }
    }
}
