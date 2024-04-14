package com.piyushprajpti.pychat.data.service

import com.google.firebase.firestore.FirebaseFirestore
import com.piyushprajpti.pychat.domain.service.AuthService

class AuthServiceImpl(
    private val db: FirebaseFirestore
) : AuthService {

    override suspend fun register(name: String, username: String, email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun login(email: String, password: String) {
        TODO("Not yet implemented")
    }

}