package com.piyushprajpti.pychat.di

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.piyushprajpti.pychat.data.repository.CommonRepositoryImpl
import com.piyushprajpti.pychat.data.service.CommonServiceImpl
import com.piyushprajpti.pychat.domain.repository.CommonRepository
import com.piyushprajpti.pychat.domain.service.CommonService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CommonModule {

    @Singleton
    @Provides
    fun providesDB() : FirebaseFirestore {
        return Firebase.firestore
    }

    @Singleton
    @Provides
    fun providesAuth() : FirebaseAuth {
        return Firebase.auth
    }

    @Singleton
    @Provides
    fun providesCommonRepository(service: CommonService) : CommonRepository {
        return CommonRepositoryImpl(service)
    }

    @Singleton
    @Provides
    fun providesCommonService(db: FirebaseFirestore): CommonService {
        return CommonServiceImpl(db)
    }

}