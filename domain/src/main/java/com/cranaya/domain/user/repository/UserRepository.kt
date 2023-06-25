package com.cranaya.domain.user.repository

import com.cranaya.domain.user.model.User
import com.cranaya.domain.shared.Resource
import java.io.File

interface UserRepository {
    suspend fun update(id: String, user: User): Resource<User>
    suspend fun updateWithImage(id: String, user: User, file: File): Resource<User>
}