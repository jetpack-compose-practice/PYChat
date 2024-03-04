package com.piyushprajpti.pychat.domain.use_case.auth

import com.piyushprajpti.pychat.domain.repository.AuthRepository

class Register (
    val authRepository: AuthRepository
) {
    operator fun invoke() {
        authRepository.register()
    }
}