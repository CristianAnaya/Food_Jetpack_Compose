package com.cranaya.domain.mercadopago.usecase

import com.cranaya.domain.mercadopago.model.CardTokenBody
import com.cranaya.domain.mercadopago.model.PaymentBody
import com.cranaya.domain.mercadopago.repository.MercadoPagoRepository

class CreatePaymentUseCase(private val mercadoPagoRepository: MercadoPagoRepository) {
    suspend operator fun invoke(paymentBody: PaymentBody) = mercadoPagoRepository.createPayment(paymentBody)
}