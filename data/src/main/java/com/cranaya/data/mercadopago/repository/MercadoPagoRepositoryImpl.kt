package com.cranaya.data.mercadopago.repository

import com.cranaya.data.mercadopago.repository.dataSource.MercadoPagoRemoteDataSource
import com.cranaya.domain.mercadopago.model.CardTokenBody
import com.cranaya.domain.mercadopago.model.CardTokenResponse
import com.cranaya.domain.mercadopago.model.IdentificationType
import com.cranaya.domain.mercadopago.model.Installment
import com.cranaya.domain.mercadopago.model.PaymentBody
import com.cranaya.domain.mercadopago.model.PaymentResponse
import com.cranaya.domain.mercadopago.repository.MercadoPagoRepository
import com.cranaya.domain.shared.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class MercadoPagoRepositoryImpl(private val mercadoPagoRemoteDataSource: MercadoPagoRemoteDataSource): MercadoPagoRepository {

    override fun getIdentificationTypes(): Flow<Resource<List<IdentificationType>>> = flow {
        emit(mercadoPagoRemoteDataSource.getIdentificationTypes())
    }

    override fun getInstallments(firstSixDigits: Int, amount: Double): Flow<Resource<Installment>> = flow {
        emit(mercadoPagoRemoteDataSource.getInstallments(firstSixDigits, amount))
    }

    override suspend fun createCardToken(cardTokenBody: CardTokenBody): Resource<CardTokenResponse> {
        return try {
            mercadoPagoRemoteDataSource.createCardToken(cardTokenBody)
        } catch (e: Exception) {
            Resource.Failure(e.message!!)
        }
    }

    override suspend fun createPayment(paymentBody: PaymentBody): Resource<PaymentResponse> {
        return try {
            mercadoPagoRemoteDataSource.createPayment(paymentBody)
        } catch (e: Exception) {
            Resource.Failure(e.message!!)
        }
    }

}