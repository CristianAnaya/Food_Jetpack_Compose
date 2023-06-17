package com.cranaya.data.user.repository.dataSource

import com.cranaya.domain.user.model.User
import com.cranaya.domain.shared.Resource

interface UserRemoteDataSource {

    suspend fun update(id: String, user: User): Resource<User>
}