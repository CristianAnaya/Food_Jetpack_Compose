package com.cranaya.domain.auth.usecase

import com.cranaya.domain.auth.repository.AuthRepository


class GetSessionDataUseCase constructor(private val authRepository: AuthRepository) {
    operator fun invoke() = authRepository.getSessionData()
}