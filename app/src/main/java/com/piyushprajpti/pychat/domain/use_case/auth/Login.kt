package com.piyushprajpti.pychat.domain.use_case.auth

import com.piyushprajpti.pychat.domain.repository.AuthRepository

class Login(
    val repository: AuthRepository
) {
    operator fun invoke() {
        repository.login()
    }
}