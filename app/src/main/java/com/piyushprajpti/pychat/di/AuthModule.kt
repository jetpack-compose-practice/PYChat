package com.piyushprajpti.pychat.di

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.piyushprajpti.pychat.data.repository.AuthRepositoryImpl
import com.piyushprajpti.pychat.data.service.AuthServiceImpl
import com.piyushprajpti.pychat.domain.repository.AuthRepository
import com.piyushprajpti.pychat.domain.service.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Singleton
    @Provides
    fun providesAuthRepository(service: AuthService): AuthRepository {
        return AuthRepositoryImpl(service)
    }

    @Singleton
    @Provides
    fun providesAuthService(usersCollection: CollectionReference): AuthService {
        return AuthServiceImpl(usersCollection)
    }
}