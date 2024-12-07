//package com.cs407.connectech.auth
//
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.connectech.app.repository.AuthRepository
//import com.cs407.connectech.model.User
//import com.cs407.connectech.network.ApiService
//import com.cs407.connectech.network.RetrofitClient
//import kotlinx.coroutines.launch
////import androidx.fragment.app.viewModels
//
//class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {
//
//    //private val apiService = RetrofitClient().getClient().create(ApiService::class.java)
//    //private val authRepository = AuthRepository(apiService)
//
//    val loginResult = MutableLiveData<Result<User>>()
//    val registerResult = MutableLiveData<Result<User>>()
//    val resetPasswordResult = MutableLiveData<Result<Void?>>()
//
//    fun login(email: String, password: String) {
//        viewModelScope.launch {
//            loginResult.value = authRepository.login(email, password)
//        }
//    }
//
//    fun register(email: String, password: String) {
//        viewModelScope.launch {
//            registerResult.value = authRepository.register(email, password)
//        }
//    }
//
//    fun resetPassword(email: String) {
//        viewModelScope.launch {
//            resetPasswordResult.value = authRepository.resetPassword(email)
//        }
//    }
//}

package com.cs407.connectech.auth
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.connectech.app.repository.AuthRepository
import com.cs407.connectech.model.User
import com.cs407.connectech.network.ApiService
import com.cs407.connectech.network.RetrofitClient
import kotlinx.coroutines.launch
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import com.cs407.connectech.model.Match

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {

    val loginResult = MutableLiveData<Result<User>>()
    val registerResult = MutableLiveData<Result<User>>()
    val resetPasswordResult = MutableLiveData<Result<Void?>>()
    val problemSubmissionResult = MutableLiveData<Result<Boolean>>() // LiveData for problem submission

    // LiveData to hold the list of matches
    private val _bestMatches = MutableLiveData<List<Match>>()
    val bestMatches: LiveData<List<Match>> get() = _bestMatches

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                //val user = authRepository.login(email, password)
                loginResult.value = authRepository.login(email, password)
            } catch (e: Exception) {
                loginResult.value = Result.failure(e)
            }
        }
    }

    fun register(email: String, password: String) {
        viewModelScope.launch {
            try {
                //val user = authRepository.register(email, password)
                registerResult.value = authRepository.register(email, password)
            } catch (e: Exception) {
                registerResult.value = Result.failure(e)
            }
        }
    }

    fun resetPassword(email: String) {
        viewModelScope.launch {
            try {
                resetPasswordResult.value = authRepository.resetPassword(email)
            } catch (e: Exception) {
                resetPasswordResult.value = Result.failure(e)
            }
        }

    }

    // Function to fetch best matches
    fun fetchBestMatches() {
        viewModelScope.launch {
            try {
                val matches = authRepository.getBestMatches()
                _bestMatches.value = matches
            } catch (e: Exception) {
                _bestMatches.value = emptyList()
            }
        }
    }

    fun submitProblem(problemDetails: String, category: String) {
        viewModelScope.launch {
            try {
                val result = authRepository.submitProblem(problemDetails, category)
                problemSubmissionResult.value = Result.success(result)
            } catch (e: Exception) {
                problemSubmissionResult.value = Result.failure(e)
            }
        }
    }
}