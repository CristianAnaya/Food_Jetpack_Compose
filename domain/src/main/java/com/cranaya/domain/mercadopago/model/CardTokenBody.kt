package com.cranaya.domain.mercadopago.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CardTokenBody (
    @SerializedName("card_number")
    val cardNumber: String,

    @SerializedName("expiration_year")
    val expirationYear: String,

    @SerializedName("expiration_month")
    val expirationMonth: Int,

    @SerializedName("security_code")
    val securityCode: String,

    val cardholder: Cardholder
): Serializable {
    fun toJson(): String = Gson().toJson(this)

    companion object {
        fun fromJson(data: String): CardTokenBody = Gson().fromJson(data, CardTokenBody::class.java)
    }
}