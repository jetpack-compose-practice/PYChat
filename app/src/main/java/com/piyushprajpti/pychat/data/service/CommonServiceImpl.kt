package com.piyushprajpti.pychat.data.service

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.piyushprajpti.pychat.domain.service.CommonService

class CommonServiceImpl(
    private val usersCollection: CollectionReference
) : CommonService {
    override suspend fun resetPassword(email: String) {
        TODO("Not yet implemented")
    }
}