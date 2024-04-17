package com.piyushprajpti.pychat.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piyushprajpti.pychat.domain.repository.AuthRepository
import com.piyushprajpti.pychat.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    fun onRegister(
        name: String,
        username: String,
        email: String,
        password: String,
        callBack: (Response<Boolean>) -> Unit
    ) {
        viewModelScope.launch {
            val response = repository.register(name, username, email, password)
            callBack(response)
        }
    }

    fun onLogin(emailOrUsername: String, password: String, callBack: (Response<String>) -> Unit) {
        viewModelScope.launch {
            val response = repository.login(emailOrUsername, password)
            callBack(response)
        }
    }


}