package com.cranaya.domain.auth.model


data class User(
    val id: String? = null,
    val name: String,
    val lastname: String,
    val email: String,
    val phone: String,
    val password: String? = null,
    val image: String? = null,
)
