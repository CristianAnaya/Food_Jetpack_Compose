package com.cranaya.domain.mercadopago.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Installment (
    @SerializedName("payment_method_id")
    val paymentMethodID: String,

    @SerializedName("payment_type_id")
    val paymentTypeID: String,

    val issuer: Issuer,

    @SerializedName("processing_mode")
    val processingMode: String,

    @SerializedName("merchant_account_id")
    val merchantAccountID: Any? = null,

    @SerializedName("payer_costs")
    val payerCosts: List<PayerCost>,

    val agreements: Any? = null
): Serializable {
    fun toJson(): String = Gson().toJson(this)

    companion object {
        fun fromJson(data: String): Installment = Gson().fromJson(data, Installment::class.java)
    }
}

data class Issuer (
    val id: String,
    val name: String,

    @SerializedName("secure_thumbnail")
    val secureThumbnail: String,

    val thumbnail: String
)

data class PayerCost (
    val installments: Int,

    @SerializedName("installment_rate")
    val installmentRate: Long,

    @SerializedName("discount_rate")
    val discountRate: Long,

    @SerializedName("reimbursement_rate")
    val reimbursementRate: Any? = null,

    val labels: List<String>,

    @SerializedName("installment_rate_collector")
    val installmentRateCollector: List<InstallmentRateCollector>,

    @SerializedName("min_allowed_amount")
    val minAllowedAmount: Long,

    @SerializedName("max_allowed_amount")
    val maxAllowedAmount: Long,

    @SerializedName("recommended_message")
    val recommendedMessage: String,

    @SerializedName("installment_amount")
    val installmentAmount: Double,

    @SerializedName("total_amount")
    val totalAmount: Long,

    @SerializedName("payment_method_option_id")
    val paymentMethodOptionID: PaymentMethodOptionID
)

enum class InstallmentRateCollector(val value: String) {
    Mercadopago("MERCADOPAGO"),
    ThirdParty("THIRD_PARTY");

    companion object {
        public fun fromValue(value: String): InstallmentRateCollector = when (value) {
            "MERCADOPAGO" -> Mercadopago
            "THIRD_PARTY" -> ThirdParty
            else          -> throw IllegalArgumentException()
        }
    }
}

enum class PaymentMethodOptionID(val value: String) {
    The1AQokODLLZjQyNjktYjAzMy00OWU1LWJhMWQtNDE0NjQyNTM3MzY4EJaFuevHLg("1.AQokODllZjQyNjktYjAzMy00OWU1LWJhMWQtNDE0NjQyNTM3MzY4EJaFuevHLg");

    companion object {
        public fun fromValue(value: String): PaymentMethodOptionID = when (value) {
            "1.AQokODllZjQyNjktYjAzMy00OWU1LWJhMWQtNDE0NjQyNTM3MzY4EJaFuevHLg" -> The1AQokODLLZjQyNjktYjAzMy00OWU1LWJhMWQtNDE0NjQyNTM3MzY4EJaFuevHLg
            else                                                               -> throw IllegalArgumentException()
        }
    }
}