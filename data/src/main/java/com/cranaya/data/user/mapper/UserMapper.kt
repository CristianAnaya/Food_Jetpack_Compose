package com.cranaya.data.user.mapper

import com.cranaya.data.auth.mapper.toRol
import com.cranaya.data.auth.mapper.toRolDto
import com.cranaya.data.user.model.UserDto
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