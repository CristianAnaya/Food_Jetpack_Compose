package com.cranaya.inc.screens.auth.login.di

import com.cranaya.domain.auth.repository.AuthRepository
import com.cranaya.domain.auth.usecase.AuthUseCase
import com.cranaya.domain.auth.usecase.GetSessionDataUseCase
import com.cranaya.domain.auth.usecase.LoginUseCase
import com.cranaya.domain.auth.usecase.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object LoginDependencyInjection {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository = authRepository),
        register = RegisterUseCase(authRepository = authRepository),
        getSessionData = GetSessionDataUseCase(authRepository = authRepository)
    )
}