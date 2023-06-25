package com.cranaya.data.user.repository.dataSource

import com.cranaya.domain.user.model.User
import com.cranaya.domain.shared.Resource
import java.io.File

interface UserRemoteDataSource {

    suspend fun update(id: String, user: User): Resource<User>
    suspend fun updateWithImage(id: String, user: User, file: File): Resource<User>
}