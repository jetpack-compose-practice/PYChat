package com.piyushprajpti.pychat.presentation.auth

import androidx.lifecycle.ViewModel
import com.piyushprajpti.pychat.domain.use_case.auth.AuthUseCase

class LoginViewModel(
    val authUseCase: AuthUseCase
): ViewModel() {
    fun login() {
        authUseCase.login()
    }
}