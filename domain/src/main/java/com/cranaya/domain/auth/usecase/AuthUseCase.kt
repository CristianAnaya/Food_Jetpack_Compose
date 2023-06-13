package com.cranaya.domain.auth.usecase

data class AuthUseCase(
    val login: LoginUseCase,
    val register: RegisterUseCase
)
