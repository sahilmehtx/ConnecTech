package com.cs407.connectech.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cs407.connectech.model.User
import com.cs407.connectech.repository.AuthRepository
import com.cs407.connectech.network.ApiService
import com.cs407.connectech.network.RetrofitClient
import kotlinx.coroutines.launch
//import androidx.fragment.app.viewModels

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {

    //private val apiService = RetrofitClient().getClient().create(ApiService::class.java)
    //private val authRepository = AuthRepository(apiService)

    val loginResult = MutableLiveData<Result<User>>()
    val registerResult = MutableLiveData<Result<User>>()
    val resetPasswordResult = MutableLiveData<Result<Void?>>()

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
}
