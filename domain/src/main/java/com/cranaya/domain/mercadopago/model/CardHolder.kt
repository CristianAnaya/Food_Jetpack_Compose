package com.cranaya.domain.mercadopago.model

data class Cardholder (
    val name: String,
    val identification: Identification
)

data class Identification (
    val type: String,
    val number: String
)