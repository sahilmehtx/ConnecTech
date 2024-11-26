import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.connectech.app.repository.AuthRepository
import com.cs407.connectech.model.Match  // Add the Match model
import com.cs407.connectech.model.User
import kotlinx.coroutines.launch

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {

    val loginResult = MutableLiveData<Result<User>>()
    val registerResult = MutableLiveData<Result<User>>()
    val resetPasswordResult = MutableLiveData<Result<Void?>>()
    val problemSubmissionResult =
        MutableLiveData<Result<Boolean>>() // LiveData for problem submission

    // LiveData to hold the list of matches
    private val _bestMatches = MutableLiveData<List<Match>>()
    val bestMatches: LiveData<List<Match>> get() = _bestMatches

    // Function to fetch best matches
    fun fetchBestMatches() {
        viewModelScope.launch {
            try {
                val matches = authRepository.getBestMatches()  // Assumes a method in AuthRepository
                _bestMatches.value = matches
            } catch (e: Exception) {
                _bestMatches.value = emptyList()  // Set empty list in case of error
            }
        }
    }

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
            try {
                val result = authRepository.submitProblem(problemDetails, category)
                problemSubmissionResult.value = Result.success(result)
            } catch (e: Exception) {
                problemSubmissionResult.value = Result.failure(e)
            }
        }
    }

}


