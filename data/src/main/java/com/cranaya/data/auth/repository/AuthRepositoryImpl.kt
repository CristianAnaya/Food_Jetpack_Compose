package com.cranaya.data.auth.repository

import com.cranaya.data.auth.repository.dataSource.AuthRemoteDataSource
import com.cranaya.data.auth.repository.dataSource.AuthTemporalDataSource
import com.cranaya.domain.auth.model.Auth
import com.cranaya.domain.user.model.User
import com.cranaya.domain.auth.repository.AuthRepository
import com.cranaya.domain.shared.Resource
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authTemporalDataSource: AuthTemporalDataSource
): AuthRepository {

    override suspend fun login(email: String, password: String): Resource<Auth> {
        val loginResult = authRemoteDataSource.login(email, password)

        if (loginResult is Resource.Success) {
            val auth = loginResult.data
            authTemporalDataSource.saveSession(auth)
        }

        return loginResult
    }

    override suspend fun register(user: User): Resource<Auth> {
        val registerResult = authRemoteDataSource.register(user)

        if (registerResult is Resource.Success) {
            val auth = registerResult.data
            authTemporalDataSource.saveSession(auth)
        }

        return registerResult
    }

    override fun getSessionData(): Flow<Auth> {
        return authTemporalDataSource.getSessionData()
    }

    override suspend fun logout() = authTemporalDataSource.logout()

}