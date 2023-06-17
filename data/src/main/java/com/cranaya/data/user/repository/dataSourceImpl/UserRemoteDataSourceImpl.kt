package com.cranaya.data.user.repository.dataSourceImpl

import com.cranaya.data.auth.mapper.toUser
import com.cranaya.data.auth.mapper.toUserDto
import com.cranaya.data.shared.httpClient.config.ResponseToRequest
import com.cranaya.data.user.repository.dataSource.UserRemoteDataSource
import com.cranaya.data.user.service.UserService
import com.cranaya.domain.user.model.User
import com.cranaya.domain.shared.Resource

class UserRemoteDataSourceImpl(private val userService: UserService): UserRemoteDataSource {

    override suspend fun update(id: String, user: User): Resource<User> {
        val userDto = user.toUserDto()
        val userResponse = userService.update(id, userDto)
        return ResponseToRequest.send(userResponse) {
            it.toUser()
        }
    }

}