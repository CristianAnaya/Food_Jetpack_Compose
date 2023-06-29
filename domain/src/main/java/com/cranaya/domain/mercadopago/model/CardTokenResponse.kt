package com.cranaya.domain.mercadopago.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CardTokenResponse (
    val id: String,

    @SerializedName("public_key")
    val publicKey: String,

    @SerializedName("first_six_digits")
    val firstSixDigits: String,

    @SerializedName("expiration_month")
    val expirationMonth: Long,

    @SerializedName("expiration_year")
    val expirationYear: Long,

    @SerializedName("last_four_digits")
    val lastFourDigits: String,

    val cardholder: Cardholder,
    val status: String,

    @SerializedName("date_created")
    val dateCreated: String,

    @SerializedName("date_last_updated")
    val dateLastUpdated: String,

    @SerializedName("date_due")
    val dateDue: String,

    @SerializedName("luhn_validation")
    val luhnValidation: Boolean,

    @SerializedName("live_mode")
    val liveMode: Boolean,

    @SerializedName("require_esc")
    val requireEsc: Boolean,

    @SerializedName("card_number_length")
    val cardNumberLength: Long,

    @SerializedName("security_code_length")
    val securityCodeLength: Long
): Serializable {
    fun toJson(): String = Gson().toJson(this)

    companion object {
        fun fromJson(data: String): CardTokenResponse = Gson().fromJson(data, CardTokenResponse::class.java)
    }
}