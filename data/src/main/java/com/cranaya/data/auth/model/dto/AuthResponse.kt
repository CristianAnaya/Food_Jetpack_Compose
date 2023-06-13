package com.cranaya.data.auth.model.dto

import com.google.gson.Gson

data class AuthResponse(
    val user: UserDto ,
    val token: String
) {

    fun toJson(): String = Gson().toJson(this)

    companion object {
        fun fromJson(data: String): AuthResponse = Gson().fromJson(data, AuthResponse::class.java)
    }
}
