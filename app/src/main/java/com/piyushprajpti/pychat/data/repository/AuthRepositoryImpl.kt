package com.piyushprajpti.pychat.data.repository

import android.util.Log
import com.piyushprajpti.pychat.domain.repository.AuthRepository
import com.piyushprajpti.pychat.domain.service.AuthService
import com.piyushprajpti.pychat.util.Response
import kotlinx.coroutines.tasks.await

const val TAG = "TAG"

class AuthRepositoryImpl(
    private val service: AuthService
) : AuthRepository {

    override suspend fun register(
        name: String,
        username: String,
        email: String,
        password: String
    ): Response<Boolean> {

        fun isValidEmail(email: String): Boolean {
            val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
            return email.matches(emailRegex)
        }

        if (name.isBlank() || username.isBlank() || email.isBlank() || password.isBlank()) {
            return Response.Error("Please fill all fields to continue")
        } else if (!isValidEmail(email)) {
            return Response.Error("Invalid email entered. Please use correct email address")
        } else if (password.length < 6) {
            return Response.Error("Weak password. Please use strong password")
        }

        try {

            val usernameResponse = service.usernameChecker(username).await()
            val emailResponse = service.emailChecker(email).await()

            return if (!usernameResponse.isEmpty) {
                Response.Error("Username already taken. Please try with another username")
            } else if (!emailResponse.isEmpty) {
                Response.Error("Email already registered. Please login to continue")
            } else {
                service.register(name, username, email, password)
                Log.d(TAG, "register: registered successfully")
                Response.Success(true)
            }

        } catch (e: Exception) {
            Log.d(TAG, "register: ${e.message}")
            return Response.Error(e.message.toString())
        }
    }

    override suspend fun login(
        emailOrUsername: String,
        password: String
    ): Response<String> {

        if (emailOrUsername.isBlank() || password.isBlank()) {
            return Response.Error("Please fill all fields to continue")
        }

        return try {
            val response = service.loginDetailsChecker(emailOrUsername).await()

            if (response.isEmpty) {
                Response.Error("Account not found. Please register to continue")
            } else {
                val username = response.documents[0].id
                val areDetailsCorrect = service.login(username, password).await()

                if (areDetailsCorrect.isEmpty) {
                    return Response.Error("Wrong password. Please try again")
                } else {
                    Response.Success(username)
                }
            }

        } catch (e: Exception) {
            Response.Error("${e.message}")
        }

    }
}