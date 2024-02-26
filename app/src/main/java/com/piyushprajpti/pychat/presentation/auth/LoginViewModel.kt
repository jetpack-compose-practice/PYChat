package com.piyushprajpti.pychat.presentation.auth

import androidx.lifecycle.ViewModel
import com.piyushprajpti.pychat.domain.use_case.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val authUseCase: AuthUseCase
): ViewModel() {
    fun login() {
        authUseCase.login()
    }
}