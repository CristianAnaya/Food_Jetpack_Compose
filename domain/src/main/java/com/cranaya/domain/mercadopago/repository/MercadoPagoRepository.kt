package com.cranaya.domain.mercadopago.repository

import com.cranaya.domain.mercadopago.model.IdentificationType
import com.cranaya.domain.mercadopago.model.Installment
import com.cranaya.domain.shared.Resource
import kotlinx.coroutines.flow.Flow

interface MercadoPagoRepository {

    fun getIdentificationTypes(): Flow<Resource<List<IdentificationType>>>
    fun getInstallments(firstSixDigits: Int, amount: Double): Flow<Resource<Installment>>

}