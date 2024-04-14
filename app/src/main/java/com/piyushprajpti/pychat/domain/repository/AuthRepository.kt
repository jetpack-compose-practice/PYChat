package com.piyushprajpti.pychat.domain.repository

interface AuthRepository {

    suspend fun register(name: String, username: String, email: String, password: String)

    suspend fun login(email: String, password: String)

}