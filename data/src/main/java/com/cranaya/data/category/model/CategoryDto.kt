package com.cranaya.data.category.model

import com.cranaya.data.auth.model.dto.AuthDto
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class CategoryDto(
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String? = null
) {

    companion object {
        fun fromJson(data: String): CategoryDto = Gson().fromJson(data, CategoryDto::class.java)
    }
}
