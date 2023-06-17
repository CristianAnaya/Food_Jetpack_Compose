package com.cranaya.domain.auth.repository

import com.cranaya.domain.auth.model.Auth
import com.cranaya.domain.user.model.User
import com.cranaya.domain.shared.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(email: String, password: String): Resource<Auth>
    suspend fun register(user: User): Resource<Auth>
    fun getSessionData(): Flow<Auth>
    suspend fun logout()
}