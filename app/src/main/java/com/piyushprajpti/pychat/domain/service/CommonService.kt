package com.piyushprajpti.pychat.domain.service

interface CommonService {

    suspend fun resetPassword(email: String)

}