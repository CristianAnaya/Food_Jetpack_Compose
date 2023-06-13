package com.cranaya.data.auth.repository

import com.cranaya.data.auth.repository.dataSource.AuthRemoteDataSource
import com.cranaya.data.auth.repository.dataSource.AuthTemporalDataSource
import com.cranaya.domain.auth.model.User
import com.cranaya.domain.auth.repository.AuthRepository
import com.cranaya.domain.shared.Resource

class AuthRepositoryImpl(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authTemporalDataSource: AuthTemporalDataSource
): AuthRepository {

    override suspend fun login(email: String, password: String): Resource<User> {
        return authRemoteDataSource.login(
            email = email,
            password = password
        )
    }

    override suspend fun register(user: User): Resource<User> {
        return authRemoteDataSource.register(
            user
        )
    }

}