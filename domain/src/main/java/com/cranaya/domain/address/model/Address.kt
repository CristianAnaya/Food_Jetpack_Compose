package com.cranaya.domain.address.model

import com.google.gson.Gson

data class Address(
    val id: String? = null,
    val address: String,
    val neighborhood: String,
    val idUser: String
) {

    fun toJson(): String = Gson().toJson(this)

    companion object {
        fun fromJson(data: String): Address = Gson().fromJson(data, Address::class.java)
    }

}
