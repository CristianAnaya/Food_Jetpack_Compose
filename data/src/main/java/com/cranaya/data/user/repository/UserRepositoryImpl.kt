package com.cranaya.data.user.repository

import com.cranaya.data.user.repository.dataSource.UserRemoteDataSource
import com.cranaya.domain.user.model.User
import com.cranaya.domain.shared.Resource
import com.cranaya.domain.user.repository.UserRepository

class UserRepositoryImpl(
    private val userRemoteDataSource: UserRemoteDataSource
): UserRepository {

    override suspend fun update(id: String, user: User): Resource<User> = userRemoteDataSource.update(id, user)

}