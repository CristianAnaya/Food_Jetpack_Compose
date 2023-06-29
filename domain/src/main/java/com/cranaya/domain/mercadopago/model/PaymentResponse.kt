package com.cranaya.domain.mercadopago.model

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PaymentResponse (
    val id: Long,

    @SerializedName("date_created")
    val dateCreated: String,

    @SerializedName("date_approved")
    val dateApproved: String,

    @SerializedName("date_last_updated")
    val dateLastUpdated: String,

    @SerializedName("date_of_expiration")
    val dateOfExpiration: Any? = null,

    @SerializedName("money_release_date")
    val moneyReleaseDate: String,

    @SerializedName("money_release_status")
    val moneyReleaseStatus: Any? = null,

    @SerializedName("operation_type")
    val operationType: String,

    @SerializedName("issuer_id")
    val issuerID: String,

    @SerializedName("payment_method_id")
    val paymentMethodID: String,

    @SerializedName("payment_type_id")
    val paymentTypeID: String,

    @SerializedName("payment_method")
    val paymentMethod: PaymentMethod,

    val status: String,

    @SerializedName("status_detail")
    val statusDetail: String,

    @SerializedName("currency_id")
    val currencyID: String,

    val description: Any? = null,

    @SerializedName("live_mode")
    val liveMode: Boolean,

    @SerializedName("sponsor_id")
    val sponsorID: Any? = null,

    @SerializedName("authorization_code")
    val authorizationCode: Any? = null,

    @SerializedName("money_release_schema")
    val moneyReleaseSchema: Any? = null,

    @SerializedName("taxes_amount")
    val taxesAmount: Long,

    @SerializedName("counter_currency")
    val counterCurrency: Any? = null,

    @SerializedName("brand_id")
    val brandID: Any? = null,

    @SerializedName("shipping_amount")
    val shippingAmount: Long,

    @SerializedName("build_version")
    val buildVersion: String,

    @SerializedName("pos_id")
    val posID: Any? = null,

    @SerializedName("store_id")
    val storeID: Any? = null,

    @SerializedName("integrator_id")
    val integratorID: Any? = null,

    @SerializedName("platform_id")
    val platformID: Any? = null,

    @SerializedName("corporation_id")
    val corporationID: Any? = null,

    @SerializedName("payer")
    val payer: PayerPayment,

    @SerializedName("collector_id")
    val collectorID: Long,

    @SerializedName("marketplace_owner")
    val marketplaceOwner: Any? = null,

    val metadata: Metadata,

    @SerializedName("additional_info")
    val additionalInfo: AdditionalInfo,

    val order: Metadata,

    @SerializedName("external_reference")
    val externalReference: Any? = null,

    @SerializedName("transaction_amount")
    val transactionAmount: Long,

    @SerializedName("net_amount")
    val netAmount: Long,

    val taxes: List<Tax>,

    @SerializedName("transaction_amount_refunded")
    val transactionAmountRefunded: Long,

    @SerializedName("coupon_amount")
    val couponAmount: Long,

    @SerializedName("differential_pricing_id")
    val differentialPricingID: Any? = null,

    @SerializedName("financing_group")
    val financingGroup: Any? = null,

    @SerializedName("deduction_schema")
    val deductionSchema: Any? = null,

    val installments: Long,

    @SerializedName("transaction_details")
    val transactionDetails: TransactionDetails,

    @SerializedName("fee_details")
    val feeDetails: List<FeeDetail>,

    @SerializedName("charges_details")
    val chargesDetails: List<Any?>,

    val captured: Boolean,

    @SerializedName("binary_mode")
    val binaryMode: Boolean,

    @SerializedName("call_for_authorize_id")
    val callForAuthorizeID: Any? = null,

    @SerializedName("statement_descriptor")
    val statementDescriptor: String,

    val card: Card,

    @SerializedName("notification_url")
    val notificationURL: Any? = null,

    val refunds: List<Any?>,

    @SerializedName("processing_mode")
    val processingMode: String,

    @SerializedName("merchant_account_id")
    val merchantAccountID: Any? = null,

    @SerializedName("merchant_number")
    val merchantNumber: Any? = null,

    @SerializedName("acquirer_reconciliation")
    val acquirerReconciliation: List<Any?>,

    @SerializedName("point_of_interaction")
    val pointOfInteraction: PointOfInteraction,

    val tags: Any? = null
): Serializable {
    fun toJson(): String = Gson().toJson(this)

    companion object {
        fun fromJson(data: String): PaymentResponse = Gson().fromJson(data, PaymentResponse::class.java)
    }
}

data class AdditionalInfo (
    @SerializedName("available_balance")
    val availableBalance: Any? = null,

    @SerializedName("nsu_processadora")
    val nsuProcessadora: Any? = null,

    @SerializedName("authentication_code")
    val authenticationCode: Any? = null
)

data class Card (
    val id: Any? = null,

    @SerializedName("first_six_digits")
    val firstSixDigits: String,

    @SerializedName("last_four_digits")
    val lastFourDigits: String,

    @SerializedName("expiration_month")
    val expirationMonth: Long,

    @SerializedName("expiration_year")
    val expirationYear: Long,

    @SerializedName("date_created")
    val dateCreated: String,

    @SerializedName("date_last_updated")
    val dateLastUpdated: String,

    val cardholder: Cardholder
)


data class FeeDetail (
    val type: String,
    val amount: Long,

    @SerializedName("fee_payer")
    val feePayer: String
)

typealias Metadata = JsonObject

data class PayerPayment (
    @SerializedName("first_name")
    val firstName: Any? = null,

    @SerializedName("last_name")
    val lastName: Any? = null,

    val email: String,
    val identification: Identification,
    val phone: Phone,
    val type: Any? = null,

    @SerializedName("entity_type")
    val entityType: Any? = null,

    val id: String
)

data class Phone (
    @SerializedName("area_code")
    val areaCode: Any? = null,

    val number: Any? = null,
    val extension: Any? = null
)

data class PaymentMethod (
    val id: String,
    val type: String
)

data class PointOfInteraction (
    val type: String,

    @SerializedName("business_info")
    val businessInfo: BusinessInfo
)

data class BusinessInfo (
    val unit: String,

    @SerializedName("sub_unit")
    val subUnit: String
)

data class Tax (
    val value: Long,
    val type: String
)

data class TransactionDetails (
    @SerializedName("payment_method_reference_id")
    val paymentMethodReferenceID: Any? = null,

    @SerializedName("acquirer_reference")
    val acquirerReference: Any? = null,

    @SerializedName("net_received_amount")
    val netReceivedAmount: Long,

    @SerializedName("total_paid_amount")
    val totalPaidAmount: Long,

    @SerializedName("overpaid_amount")
    val overpaidAmount: Long,

    @SerializedName("external_resource_url")
    val externalResourceURL: Any? = null,

    @SerializedName("installment_amount")
    val installmentAmount: Double,

    @SerializedName("financial_institution")
    val financialInstitution: Any? = null,

    @SerializedName("payable_deferral_period")
    val payableDeferralPeriod: Any? = null
)