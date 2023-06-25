package com.cranaya.domain.user.usecase

data class UserUseCase(
    val updateUser: UpdateUserUseCase,
    val updateUserWithImage: UpdateUserWithImageUseCase
)
