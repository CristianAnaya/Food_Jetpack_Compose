package com.cranaya.data.user.service

import com.cranaya.data.auth.model.dto.UserDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserService {

    @PUT("users/{id}")
    suspend fun update(
        @Path("id") id: String,
        @Body() user: UserDto
    ): Response<UserDto>

}