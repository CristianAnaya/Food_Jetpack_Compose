package com.cranaya.data.address.httpclient.dto

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AddressDto(
    @SerializedName("id") val id: String? = null,
    @SerializedName("address") val address: String,
    @SerializedName("neighborhood") val neighborhood: String,
    @SerializedName("id_user") val idUser: String,
): Serializable {

    fun toJson(): String = Gson().toJson(this)

    companion object {
        fun fromJson(data: String): AddressDto = Gson().fromJson(data, AddressDto::class.java)
    }
}

