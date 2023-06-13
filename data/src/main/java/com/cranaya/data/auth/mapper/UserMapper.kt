package com.cranaya.data.auth.mapper

import com.cranaya.data.auth.model.dto.UserDto
import com.cranaya.domain.auth.model.User

fun UserDto.toUser(): User {
    return User(
        id = id,
        name = name,
        lastname = lastname,
        email = email,
        phone = phone,
        image = image
    )
}

fun User.toUserDto(): UserDto {
    return UserDto(
        id = id,
        name = name,
        lastname = lastname,
        email = email,
        phone = phone,
        image = image,
        password = password
    )
}