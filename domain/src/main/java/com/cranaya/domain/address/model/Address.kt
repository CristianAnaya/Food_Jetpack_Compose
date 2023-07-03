package com.cranaya.domain.address.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable

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

data class AddressDto(
    @SerializedName("id") val id: String? = null,
//    @SerializedName("address") val address: String,
    @SerializedName("neighborhood") val neighborhood: String,
    @SerializedName("id_user") val idUser: String,
): Serializable {

    fun toJson(): String = Gson().toJson(this)

    companion object {
        fun fromJson(data: String): AddressDto = Gson().fromJson(data, AddressDto::class.java)
    }
}
