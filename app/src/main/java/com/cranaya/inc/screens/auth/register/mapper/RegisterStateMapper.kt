package com.cranaya.inc.screens.auth.register.mapper

import com.cranaya.domain.user.model.User
import com.cranaya.inc.screens.auth.register.RegisterState

fun RegisterState.toUser(): User {
    return User(
        name = name,
        lastname = lastname,
        email = email,
        phone = phone,
        password = password
    )
}