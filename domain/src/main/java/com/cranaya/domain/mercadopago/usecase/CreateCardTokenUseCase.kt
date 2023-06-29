package com.cranaya.domain.mercadopago.usecase

import com.cranaya.domain.mercadopago.model.CardTokenBody
import com.cranaya.domain.mercadopago.repository.MercadoPagoRepository

class CreateCardTokenUseCase(private val mercadoPagoRepository: MercadoPagoRepository) {
    suspend operator fun invoke(cardTokenBody: CardTokenBody) = mercadoPagoRepository.createCardToken(cardTokenBody)
}