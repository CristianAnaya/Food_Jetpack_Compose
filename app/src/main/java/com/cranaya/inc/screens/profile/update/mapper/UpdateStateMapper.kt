package com.cranaya.inc.screens.profile.update.mapper

import com.cranaya.domain.user.model.User
import com.cranaya.inc.screens.profile.update.ProfileUpdateState


fun ProfileUpdateState.toUser(): User {
    return User(
        name = name,
        lastname = lastname,
        phone = phone,
        image = image
    )
}