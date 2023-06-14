package com.cranaya.data.auth.mapper

import com.cranaya.data.auth.model.dto.RolDto
import com.cranaya.domain.auth.model.Rol

fun RolDto.toRol(): Rol {
    return Rol(
        id = id,
        name = name,
        image = image,
        route = route
    )
}

fun Rol.toRolDto(): RolDto {
    return RolDto(
        id = id,
        name = name,
        image = image,
        route = route
    )
}