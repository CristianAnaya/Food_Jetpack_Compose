package com.cranaya.domain.auth.usecase

import com.cranaya.domain.auth.repository.AuthRepository

class LogoutUseCase constructor(private val authRepository: AuthRepository) {
    suspend operator fun invoke() = authRepository.logout()
}