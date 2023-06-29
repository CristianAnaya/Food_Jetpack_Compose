package com.cranaya.domain.mercadopago.usecase

data class MercadoPagoUseCase(
    val getIdentificationType: GetIdentificationTypeUseCase,
    val getInstallments: GetInstallmentsUseCase
)
