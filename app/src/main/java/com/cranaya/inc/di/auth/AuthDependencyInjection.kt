package com.cranaya.inc.di.auth

import com.cranaya.domain.auth.repository.AuthRepository
import com.cranaya.domain.auth.usecase.AuthUseCase
import com.cranaya.domain.auth.usecase.GetSessionDataUseCase
import com.cranaya.domain.auth.usecase.LoginUseCase
import com.cranaya.domain.auth.usecase.LogoutUseCase
import com.cranaya.domain.auth.usecase.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object AuthDependencyInjection {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository = authRepository),
        register = RegisterUseCase(authRepository = authRepository),
        getSessionData = GetSessionDataUseCase(authRepository = authRepository),
        logout = LogoutUseCase(authRepository = authRepository)
    )
}