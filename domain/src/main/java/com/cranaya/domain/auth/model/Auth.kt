package com.cranaya.domain.auth.model

data class Auth(
    val user: User? = null,
    val token: String? = null
)
