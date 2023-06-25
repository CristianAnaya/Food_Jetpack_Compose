package com.cranaya.domain.category.model

import com.cranaya.domain.auth.model.Rol
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class Category(
    val id: String? = null,
    val name: String,
    val description: String,
    val image: String? = null
): Serializable {
    fun toJson(): String = Gson().toJson(Category(
        id,
        name,
        description,
        if (!image.isNullOrBlank()) URLEncoder.encode(image, StandardCharsets.UTF_8.toString()) else "",
    ))

    companion object {
        fun fromJson(data: String): Category = Gson().fromJson(data, Category::class.java)
    }
}
