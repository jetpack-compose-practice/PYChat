package com.piyushprajpti.pychat.domain.repository

interface CommonRepository {

    suspend fun resetPassword(email: String)

}