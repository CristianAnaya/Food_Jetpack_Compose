package com.cranaya.domain.user.usecase

import com.cranaya.domain.user.model.User
import com.cranaya.domain.user.repository.UserRepository

class UpdateUserUseCase constructor(private val userRepository: UserRepository) {

    suspend operator fun invoke(id: String, user: User) = userRepository.update(id, user)

}