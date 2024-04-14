package com.piyushprajpti.pychat.data.repository

import com.piyushprajpti.pychat.domain.repository.CommonRepository
import com.piyushprajpti.pychat.domain.service.CommonService

class CommonRepositoryImpl(
    val service: CommonService
) : CommonRepository {
    override suspend fun resetPassword(email: String) {
        service.resetPassword("")
    }
}