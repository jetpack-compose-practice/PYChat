package com.piyushprajpti.pychat.data.service

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.Filter
import com.google.firebase.firestore.QuerySnapshot
import com.piyushprajpti.pychat.domain.service.AuthService

class AuthServiceImpl(
    private val usersCollection: CollectionReference
) : AuthService {

    override suspend fun register(
        name: String,
        username: String,
        email: String,
        password: String
    ): Task<Void> {
        return usersCollection.document(username).set(
            hashMapOf(
                "name" to name,
                "username" to username,
                "email" to email,
                "password" to password
            )
        )
    }

    override suspend fun login(username: String, password: String): Task<QuerySnapshot> {
        return usersCollection.where(
            Filter.and(
                Filter.equalTo("username", username),
                Filter.equalTo("password", password)
            )
        ).get()
    }

    override suspend fun usernameChecker(username: String): Task<QuerySnapshot> {
        return usersCollection.whereEqualTo("username", username).get()
    }

    override suspend fun emailChecker(email: String): Task<QuerySnapshot> {
        return usersCollection.whereEqualTo("email", email).get()
    }

    override suspend fun loginDetailsChecker(emailOrUsername: String): Task<QuerySnapshot> {
        return usersCollection.where(
            Filter.or(
                Filter.equalTo("username", emailOrUsername),
                Filter.equalTo("email", emailOrUsername)
            )
        ).get()
    }

}