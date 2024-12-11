// File: AuthViewModel.kt
package com.cs407.connectech.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cs407.connectech.model.User
import com.cs407.connectech.repository.AuthRepository
import kotlinx.coroutines.launch

/**
 * ViewModel for handling authentication operations.
 *
 * @property authRepository Repository for authentication-related data operations.
 */
class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {

    val loginResult = MutableLiveData<Result<User>>()
    val registerResult = MutableLiveData<Result<User>>()
    //val resetPasswordResult = MutableLiveData<Result<Void?>>()
    val problemSubmissionResult = MutableLiveData<Result<Boolean>>() // LiveData for problem submission

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                loginResult.value = authRepository.login(email, password)
            } catch (e: Exception) {
                loginResult.value = Result.failure(e)
            }
        }
    }

    private val _resetPasswordResult = MutableLiveData<Result<Void?>>()
    val resetPasswordResult: LiveData<Result<Void?>> get() = _resetPasswordResult

    fun resetPassword(email: String) {
        viewModelScope.launch {
            val result = authRepository.resetPassword(email)
            _resetPasswordResult.postValue(result)
        }
    }

    fun register(email: String, password: String): LiveData<Result<User>> {
        val result = MutableLiveData<Result<User>>()

        viewModelScope.launch {
            val registrationResult = authRepository.register(email, password)
            result.postValue(registrationResult.value)
        }

        return result
    }



    fun submitProblem(problemDetails: String, category: String) {
        viewModelScope.launch {
            try {
                val result = authRepository.submitProblem(problemDetails, category)
                problemSubmissionResult.value = result // Corrected assignment
            } catch (e: Exception) {
                problemSubmissionResult.value = Result.failure(e)
            }
        }
    }

    /**
     * Logs the user out and clears session data.
     */
    fun logout() {
        authRepository.logout()
    }
}