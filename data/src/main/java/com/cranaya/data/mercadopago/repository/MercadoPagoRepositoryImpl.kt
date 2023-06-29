package com.cranaya.data.mercadopago.repository

import com.cranaya.data.mercadopago.repository.dataSource.MercadoPagoRemoteDataSource
import com.cranaya.domain.mercadopago.model.IdentificationType
import com.cranaya.domain.mercadopago.model.Installment
import com.cranaya.domain.mercadopago.repository.MercadoPagoRepository
import com.cranaya.domain.shared.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MercadoPagoRepositoryImpl(private val mercadoPagoRemoteDataSource: MercadoPagoRemoteDataSource): MercadoPagoRepository {

    override fun getIdentificationTypes(): Flow<Resource<List<IdentificationType>>> = flow {
        emit(mercadoPagoRemoteDataSource.getIdentificationTypes())
    }

    override fun getInstallments(firstSixDigits: Int, amount: Double): Flow<Resource<Installment>> = flow {
        emit(mercadoPagoRemoteDataSource.getInstallments(firstSixDigits, amount))
    }

}