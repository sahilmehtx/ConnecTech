package com.cs407.connectech.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cs407.connectech.model.User
import com.cs407.connectech.repository.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {

    val loginResult = MutableLiveData<Result<User>>()
    val registerResult = MutableLiveData<Result<User>>()
    val resetPasswordResult = MutableLiveData<Result<Void?>>()
    val problemSubmissionResult = MutableLiveData<Result<Boolean>>()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            loginResult.value = authRepository.login(email, password)
        }
    }

    fun register(email: String, password: String) {
        viewModelScope.launch {
            registerResult.value = authRepository.register(email, password)
        }
    }

    fun resetPassword(email: String) {
        viewModelScope.launch {
            resetPasswordResult.value = authRepository.resetPassword(email)
        }
    }

    fun submitProblem(problemDetails: String, category: String) {
        viewModelScope.launch {
            problemSubmissionResult.value = authRepository.submitProblem(problemDetails, category)
        }
    }

    fun logout() {
        authRepository.logout()
    }

    fun getLoggedInUserEmail(): String? = authRepository.getLoggedInUser()
}
