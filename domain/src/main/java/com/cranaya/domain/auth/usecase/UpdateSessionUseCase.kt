package com.cranaya.domain.auth.usecase

import com.cranaya.domain.auth.repository.AuthRepository
import com.cranaya.domain.user.model.User

class UpdateSessionUseCase constructor(private val authRepository: AuthRepository) {
    suspend operator fun invoke(user: User) = authRepository.updateSession(user)
}