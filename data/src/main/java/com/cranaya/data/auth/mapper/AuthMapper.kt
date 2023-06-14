package com.cranaya.data.auth.mapper

import com.cranaya.data.auth.model.dto.AuthDto
import com.cranaya.domain.auth.model.Auth

fun AuthDto.toAuth(): Auth {
    return Auth(
        user = user?.toUser(),
        token = token
    )
}

fun Auth.toAuthDto(): AuthDto {
    return AuthDto(
        user = user?.toUserDto()!!,
        token = token ?: ""
    )
}