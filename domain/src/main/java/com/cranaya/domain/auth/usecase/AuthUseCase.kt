package com.cranaya.domain.auth.usecase

data class AuthUseCase(
    val login: LoginUseCase,
    val register: RegisterUseCase,
    val getSessionData: GetSessionDataUseCase,
    val logout: LogoutUseCase,
    val updateSession: UpdateSessionUseCase
)
