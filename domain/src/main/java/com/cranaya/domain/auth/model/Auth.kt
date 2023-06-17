package com.cranaya.domain.auth.model

import com.cranaya.domain.user.model.User

data class Auth(
    val user: User? = null,
    val token: String? = null
)
