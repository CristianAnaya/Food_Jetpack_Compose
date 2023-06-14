package com.cranaya.data.auth.repository.dataSource

import com.cranaya.data.auth.model.dto.AuthDto
import com.cranaya.domain.auth.model.Auth
import kotlinx.coroutines.flow.Flow

interface AuthTemporalDataSource {
    suspend fun saveSession(auth: Auth)
    fun getSessionData(): Flow<Auth>
}