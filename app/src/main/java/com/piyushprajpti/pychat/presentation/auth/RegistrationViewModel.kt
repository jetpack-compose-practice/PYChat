package com.piyushprajpti.pychat.presentation.auth

import androidx.lifecycle.ViewModel
import com.piyushprajpti.pychat.domain.use_case.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
): ViewModel()  {
    fun register() {
        authUseCase.register()
    }
}