package com.piyushprajpti.pychat.domain.repository

interface AuthRepository {

    suspend fun register(name: String, username: String, email: String, password: String, callBack: () -> Unit)

    suspend fun login(emailOrUsername: String, password: String, callBack: () -> Unit)

}