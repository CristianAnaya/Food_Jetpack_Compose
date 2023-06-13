package com.cranaya.data.auth.repository.dataSource

import com.cranaya.domain.auth.model.User
import com.cranaya.domain.shared.Resource

interface AuthRemoteDataSource {
    suspend fun login(email: String, password: String): Resource<User>
    suspend fun register(user: User): Resource<User>
}