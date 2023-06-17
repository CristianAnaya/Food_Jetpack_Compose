package com.cranaya.data.auth.repository.dataSource

import com.cranaya.domain.auth.model.Auth
import com.cranaya.domain.user.model.User
import com.cranaya.domain.shared.Resource

interface AuthRemoteDataSource {
    suspend fun login(email: String, password: String): Resource<Auth>
    suspend fun register(user: User): Resource<Auth>
}