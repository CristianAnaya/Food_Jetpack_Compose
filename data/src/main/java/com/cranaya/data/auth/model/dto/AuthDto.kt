package com.cranaya.data.auth.model.dto

import com.google.gson.Gson

data class AuthDto(
    val user: UserDto ?= null,
    val token: String? = null
) {

    fun toJson(): String = Gson().toJson(this)

    companion object {
        fun fromJson(data: String): AuthDto = Gson().fromJson(data, AuthDto::class.java)
    }
}
