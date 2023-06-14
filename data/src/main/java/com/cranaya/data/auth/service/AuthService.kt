package com.cranaya.data.auth.service

import com.cranaya.data.auth.model.dto.AuthDto
import com.cranaya.data.auth.model.dto.UserDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {

    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<AuthDto>

    @POST("auth/register")
    suspend fun register(
        @Body() user: UserDto
    ): Response<AuthDto>
}