package com.cranaya.data.mercadopago.repository.dataSource

import com.cranaya.domain.mercadopago.model.IdentificationType
import com.cranaya.domain.mercadopago.model.Installment
import com.cranaya.domain.shared.Resource
import kotlinx.coroutines.flow.Flow

interface MercadoPagoRemoteDataSource {
    suspend fun getIdentificationTypes(): Resource<List<IdentificationType>>
    suspend fun getInstallments(firstSixDigits: Int, amount: Double): Resource<Installment>
}