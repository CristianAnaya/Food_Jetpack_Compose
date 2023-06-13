package com.cranaya.data.auth.repository.dataSource

import com.cranaya.data.auth.model.dto.AuthResponse
import kotlinx.coroutines.flow.Flow

interface AuthTemporalDataSource {
    suspend fun saveSession(authResponse: AuthResponse)
    fun getSessionData(): Flow<AuthResponse>
}