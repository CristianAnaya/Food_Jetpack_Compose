package com.cranaya.domain.auth.repository

import com.cranaya.domain.auth.model.User
import com.cranaya.domain.shared.Resource

interface AuthRepository {
    suspend fun login(email: String, password: String): Resource<User>
    suspend fun register(user: User): Resource<User>
}