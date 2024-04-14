package com.piyushprajpti.pychat.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piyushprajpti.pychat.domain.repository.AuthRepository
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
        callBack: () -> Unit
    ) {
        viewModelScope.launch {
            repository.register(name, username, email, password)
        }
    }

    fun onLogin(email: String, password: String, callBack: () -> Unit) {
        viewModelScope.launch {
            repository.login(email, password)
        }
    }


}