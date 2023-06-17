package com.cranaya.data.auth.mapper

import com.cranaya.data.auth.model.dto.UserDto
import com.cranaya.domain.user.model.User

fun UserDto.toUser(): User {
    return User(
        id = id,
        name = name,
        lastname = lastname,
        email = email,
        phone = phone,
        image = image,
        roles = roles?.map { it.toRol() }
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
        password = password,
        roles = roles?.map { it.toRolDto() }
    )
}