package com.cranaya.domain.user.usecase

import com.cranaya.domain.user.model.User
import com.cranaya.domain.user.repository.UserRepository
import java.io.File

class UpdateUserWithImageUseCase constructor(private val userRepository: UserRepository) {

    suspend operator fun invoke(id: String, user: User, file: File) = userRepository.updateWithImage(id, user, file)

}