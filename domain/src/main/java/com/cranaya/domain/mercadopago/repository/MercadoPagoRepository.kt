package com.cranaya.domain.mercadopago.repository

import com.cranaya.domain.mercadopago.model.CardTokenBody
import com.cranaya.domain.mercadopago.model.CardTokenResponse
import com.cranaya.domain.mercadopago.model.IdentificationType
import com.cranaya.domain.mercadopago.model.Installment
import com.cranaya.domain.mercadopago.model.PaymentBody
import com.cranaya.domain.mercadopago.model.PaymentResponse
import com.cranaya.domain.shared.Resource
import kotlinx.coroutines.flow.Flow

interface MercadoPagoRepository {

    fun getIdentificationTypes(): Flow<Resource<List<IdentificationType>>>
    fun getInstallments(firstSixDigits: Int, amount: Double): Flow<Resource<Installment>>
    suspend fun createCardToken(cardTokenBody: CardTokenBody): Resource<CardTokenResponse>
    suspend fun createPayment(paymentBody: PaymentBody): Resource<PaymentResponse>
}