package com.cranaya.domain.mercadopago.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class IdentificationType (
    val id: String,
    val name: String,
    val type: String,

    @SerializedName("min_length")
    val minLength: Long,

    @SerializedName("max_length")
    val maxLength: Long
) {
    fun toJson(): String = Gson().toJson(this)

    companion object {
        fun fromJson(data: String): IdentificationType = Gson().fromJson(data, IdentificationType::class.java)
    }
}
