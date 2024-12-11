// File: AuthViewModelFactory.kt
package com.cs407.connectech.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cs407.connectech.repository.AuthRepository

/**
 * Factory to create AuthViewModel instances with a provided AuthRepository.
 *
 * @property authRepository The repository instance used by AuthViewModel.
 */
class AuthViewModelFactory(private val authRepository: AuthRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AuthViewModel(authRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}