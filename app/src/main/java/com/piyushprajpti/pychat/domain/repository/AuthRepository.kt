package com.piyushprajpti.pychat.domain.repository

import com.piyushprajpti.pychat.util.Response


interface AuthRepository {

    suspend fun register(
        name: String,
        username: String,
        email: String,
        password: String
    ): Response<Boolean>

    suspend fun login(
        emailOrUsername: String,
        password: String
    ): Response<String>

}