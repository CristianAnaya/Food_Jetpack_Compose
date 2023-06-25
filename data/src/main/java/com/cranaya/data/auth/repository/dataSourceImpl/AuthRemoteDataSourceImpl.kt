package com.cranaya.data.auth.repository.dataSourceImpl

import com.cranaya.data.auth.mapper.toAuth
import com.cranaya.data.user.mapper.toUserDto
import com.cranaya.data.auth.repository.dataSource.AuthRemoteDataSource
import com.cranaya.data.auth.service.AuthService
import com.cranaya.data.shared.httpClient.config.ResponseToRequest
import com.cranaya.domain.auth.model.Auth
import com.cranaya.domain.user.model.User
import com.cranaya.domain.shared.Resource

class AuthRemoteDataSourceImpl(private val authService: AuthService): AuthRemoteDataSource {

    override suspend fun login(email: String, password: String): Resource<Auth> {
        val response = authService.login(email, password)
        return ResponseToRequest.send(response) { authResponse ->
            authResponse.toAuth()
        }
    }

    override suspend fun register(user: User): Resource<Auth> {
        val response = authService.register(user.toUserDto())
        return ResponseToRequest.send(response) { authResponse ->
            authResponse.toAuth()
        }
    }
}