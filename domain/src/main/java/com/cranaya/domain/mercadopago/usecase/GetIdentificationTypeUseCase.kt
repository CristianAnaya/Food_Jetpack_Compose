package com.cranaya.domain.mercadopago.usecase

import com.cranaya.domain.mercadopago.repository.MercadoPagoRepository

class GetIdentificationTypeUseCase(private val mercadoPagoRepository: MercadoPagoRepository) {
    operator fun invoke() = mercadoPagoRepository.getIdentificationTypes()
}