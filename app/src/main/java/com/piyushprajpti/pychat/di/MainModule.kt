package com.piyushprajpti.pychat.di

import com.piyushprajpti.pychat.data.respository.AuthRepositoryImpl
import com.piyushprajpti.pychat.data.service.AuthServiceImpl
import com.piyushprajpti.pychat.domain.repository.AuthRepository
import com.piyushprajpti.pychat.domain.service.AuthService
import com.piyushprajpti.pychat.domain.use_case.auth.AuthUseCase
import com.piyushprajpti.pychat.domain.use_case.auth.Login
import com.piyushprajpti.pychat.domain.use_case.auth.Signup
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun useCase(repository: AuthRepository): AuthUseCase {
        return AuthUseCase(
            login = Login(repository),
            signup = Signup()
        )
    }

    @Provides
    @Singleton
    fun repository(service: AuthService): AuthRepository {
        return AuthRepositoryImpl(
            service = service
        )
    }

    @Provides
    @Singleton
    fun service(): AuthService {
        return AuthServiceImpl()
    }
}