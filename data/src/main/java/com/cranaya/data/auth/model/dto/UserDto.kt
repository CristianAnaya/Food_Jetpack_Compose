package com.cranaya.data.auth.model.dto

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String,
    @SerializedName("lastname") val lastname: String,
    @SerializedName("email") val email: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("image") val image: String? = null,
    @SerializedName("password") val password: String? =null,
    @SerializedName("notification_token") val notificationToken: String? = null
) {
    fun toJson(): String = Gson().toJson(this)

    companion object {
        fun fromJson(data: String): UserDto = Gson().fromJson(data, UserDto::class.java)
    }
}
