package com.piyushprajpti.pychat.data.repository

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.piyushprajpti.pychat.domain.repository.AuthRepository
import com.piyushprajpti.pychat.domain.service.AuthService
import com.piyushprajpti.pychat.util.Response

const val TAG = "TAG"

class AuthRepositoryImpl(
    private val service: AuthService
) : AuthRepository {

    override suspend fun register(
        name: String,
        username: String,
        email: String,
        password: String,
        callBack: () -> Unit
    ) {
        service.registerDetailsChecker(username, email)
            .addOnSuccessListener {
                if(it.isEmpty) {
                    Log.d(TAG, "register: success no account found ")
                } else {
                    Log.d(TAG, "register: account already exist")
                }
            }
            .addOnFailureListener{
                Log.d(TAG, "register: $it")
            }
        service.register(name, username, email, password)
    }

    override suspend fun login(emailOrUsername: String, password: String, callBack: () -> Unit) {
        service.loginDetailsChecker(emailOrUsername)
            .addOnSuccessListener {
                if (it.isEmpty) {
                    Log.d(TAG, "login: sorry no account found")
                } else {
                    Log.d(TAG, "login: success account found")
                }
            }
    }

}