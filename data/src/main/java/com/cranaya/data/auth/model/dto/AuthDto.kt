package com.cranaya.data.auth.model.dto

import android.util.Log
import com.google.gson.Gson

data class AuthDto(
    val user: UserDto ?= null,
    val token: String? = null
) {

    fun toJson(): String = Gson().toJson(this)

    companion object {
        fun fromJson(data: String): AuthDto {
            Log.d("UserDto", "fromJson: $data, $${Gson().fromJson(data, AuthDto::class.java)}")
            return Gson().fromJson(data, AuthDto::class.java)
        }
    }
}
