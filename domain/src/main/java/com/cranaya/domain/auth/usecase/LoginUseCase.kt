package com.cranaya.domain.auth.usecase

import com.cranaya.domain.auth.repository.AuthRepository

class LoginUseCase(private val authRepository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String) = authRepository.login(email, password)
}