package com.piyushprajpti.pychat.domain.service

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot


interface AuthService {

    suspend fun register(
        name: String,
        username: String,
        email: String,
        password: String
    ): Task<Void>

    suspend fun login(username: String, password: String): Task<QuerySnapshot>

    suspend fun registerDetailsChecker(username: String, email: String): Task<QuerySnapshot>

    suspend fun loginDetailsChecker(emailOrUsername: String): Task<QuerySnapshot>
}