package com.cranaya.domain.mercadopago.usecase

import com.cranaya.domain.mercadopago.repository.MercadoPagoRepository

class GetInstallmentsUseCase(private val mercadoPagoRepository: MercadoPagoRepository) {
    operator fun invoke(firstSixDigits: Int, amount: Double) = mercadoPagoRepository.getInstallments(firstSixDigits, amount)
}