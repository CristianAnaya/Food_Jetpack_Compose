package com.cranaya.domain.mercadopago.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PaymentBody (

    @SerializedName("transaction_amount")
    val transactionAmount: Double,

    val token: String,
    val installments: Int,

    @SerializedName("issuer_id")
    val issuerID: String,

    @SerializedName("payment_method_id")
    val paymentMethodID: String,

//    @SerializedName("order")
//    val order: Order,

    val payer: Payer
): Serializable {

    fun toJson(): String = Gson().toJson(this)

    companion object {
        fun fromJson(data: String): PaymentBody = Gson().fromJson(data, PaymentBody::class.java)
    }
}

data class Payer (
    val email: String,
    val identification: Identification
)

