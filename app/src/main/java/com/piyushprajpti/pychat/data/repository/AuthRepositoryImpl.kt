package com.piyushprajpti.pychat.data.repository

import com.piyushprajpti.pychat.domain.repository.AuthRepository
import com.piyushprajpti.pychat.domain.service.AuthService

class AuthRepositoryImpl(
    private val service: AuthService
) : AuthRepository {

    override suspend fun register(name: String, username: String, email: String, password: String) {
        service.register(name, username, email, password)
    }

    override suspend fun login(email: String, password: String) {
        service.login(email, password)
    }

}