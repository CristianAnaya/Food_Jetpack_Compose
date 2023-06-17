package com.cranaya.domain.auth.usecase

import com.cranaya.domain.user.model.User
import com.cranaya.domain.auth.repository.AuthRepository

class RegisterUseCase constructor(private val authRepository: AuthRepository) {

    suspend operator fun invoke(user: User) = authRepository.register(user = user)
}