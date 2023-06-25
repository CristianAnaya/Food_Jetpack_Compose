package com.cranaya.data.auth.repository.dataSource

import com.cranaya.domain.auth.model.Auth
import com.cranaya.domain.user.model.User
import kotlinx.coroutines.flow.Flow

interface AuthTemporalDataSource {
    suspend fun saveSession(auth: Auth)
    fun getSessionData(): Flow<Auth>
    suspend fun updateSessionData(user: User)
    suspend fun logout()
}