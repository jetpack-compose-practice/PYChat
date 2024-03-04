package com.piyushprajpti.pychat.data.respository

import com.piyushprajpti.pychat.domain.repository.AuthRepository
import com.piyushprajpti.pychat.domain.service.AuthService

class AuthRepositoryImpl(
    val service: AuthService
): AuthRepository {
    override fun login() {
       service.login()
    }

    override fun register() {
        service.register()
    }
}