package com.cs407.connectech.repository

import androidx.lifecycle.MutableLiveData
import com.cs407.connectech.data.UserDao
import com.cs407.connectech.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class FakeAuthRepository(private val userDao: UserDao) : AuthRepository {

    private var loggedInUserEmail: String? = null

    override suspend fun login(email: String, password: String): Result<User> {
        return withContext(Dispatchers.IO) {
            delay(500)
            val user = userDao.getUserByCredentials(email, password)
            if (user != null) {
                loggedInUserEmail = user.email
                Result.success(user)
            } else {
                Result.failure(Exception("Invalid email or password"))
            }
        }
    }

    override suspend fun register(email: String, password: String): Result<User> {
        return withContext(Dispatchers.IO) {
            delay(500)
            if ( password.length >= 2) {  // email.contains("@") && add this b4 password if need be
                val existing = userDao.getUserByEmail(email)
                if (existing != null) {
                    Result.failure(Exception("User already exists"))
                } else {
                    val newUser = User(email = email, name = "New User", password = password)
                    userDao.insertUser(newUser)
                    Result.success(newUser)
                }
            } else {
                Result.failure(Exception("Invalid email or password format"))
            }
        }
    }

    override suspend fun resetPassword(email: String): Result<Void?> {
        return withContext(Dispatchers.IO) {
            delay(500)
            val user = userDao.getUserByEmail(email)
            if (user != null) {
                Result.success(null)
            } else {
                Result.failure(Exception("User not found"))
            }
        }
    }

    override suspend fun submitProblem(problemDetails: String, category: String): Result<Boolean> {
        return withContext(Dispatchers.IO) {
            delay(500)
            if (problemDetails.isNotEmpty() && category.isNotEmpty()) {
                Result.success(true)
            } else {
                Result.failure(Exception("Problem details or category cannot be empty"))
            }
        }
    }

    override fun logout() {
        loggedInUserEmail = null
    }

    override fun getLoggedInUser(): String? {
        return loggedInUserEmail
    }
}
