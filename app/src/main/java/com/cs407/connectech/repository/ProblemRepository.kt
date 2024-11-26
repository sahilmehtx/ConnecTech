package com.connectech.app.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cs407.connectech.network.ApiService
import com.cs407.connectech.network.requests.SubmitProblemRequest

/**
 * ProblemRepository: Manages project data and operations.
 *
 * Variables:
 * - apiService: Instance of ApiService for API interactions.
 * - _projects: Internal MutableLiveData holding a list of projects.
 * - projects: Public LiveData exposing project data for observing in ViewModels.
 */
class ProblemRepository(private val apiService: ApiService) {

    private val _projects = MutableLiveData<List<String>>() // Tracks list of projects
    val projects: LiveData<List<String>> get() = _projects // Public observer for project data

    /**
     * Fetches the list of projects.
     */
    fun fetchProjects() {
        // Mock implementation (Replace with actual API call if needed)
        _projects.value = listOf("Project A", "Project B", "Project C")
    }

    /**
     * Submits a problem to the backend using the ApiService.
     * @param problemDetails The details of the problem.
     * @param category The category of the problem.
     */
    suspend fun submitProblem(problemDetails: String, category: String) {
        try {
            val response = apiService.submitProblem(SubmitProblemRequest(problemDetails, category))
            if (!response.isSuccessful) {
                throw Exception("Failed to submit problem")
            }
        } catch (e: Exception) {
            // Handle error
            throw e
        }
    }
}
