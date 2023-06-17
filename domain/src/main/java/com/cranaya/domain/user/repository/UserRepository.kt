package com.cranaya.domain.user.repository

import com.cranaya.domain.user.model.User
import com.cranaya.domain.shared.Resource

interface UserRepository {

    suspend fun update(id: String, user: User): Resource<User>
}