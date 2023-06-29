package com.cranaya.data.mercadopago.repository.dataSourceImpl

import android.util.Log
import com.cranaya.data.mercadopago.httpclient.service.MercadoPagoService
import com.cranaya.data.mercadopago.repository.dataSource.MercadoPagoRemoteDataSource
import com.cranaya.data.shared.httpClient.config.ResponseToRequest
import com.cranaya.domain.mercadopago.model.CardTokenBody
import com.cranaya.domain.mercadopago.model.CardTokenResponse
import com.cranaya.domain.mercadopago.model.IdentificationType
import com.cranaya.domain.mercadopago.model.Installment
import com.cranaya.domain.mercadopago.model.PaymentBody
import com.cranaya.domain.mercadopago.model.PaymentResponse
import com.cranaya.domain.shared.Resource

class MercadoPagoRemoteDataSourceImpl(private val mercadoPagoService: MercadoPagoService): MercadoPagoRemoteDataSource {

    override suspend fun getIdentificationTypes(): Resource<List<IdentificationType>> {
        val service = mercadoPagoService.getIdentificationTypes()
        return ResponseToRequest.send(service)
    }

    override suspend fun getInstallments(
        firstSixDigits: Int,
        amount: Double
    ): Resource<Installment> {
        val service = mercadoPagoService.getInstallments(firstSixDigits, amount)
        return ResponseToRequest.send(service)
    }

    override suspend fun createCardToken(cardTokenBody: CardTokenBody): Resource<CardTokenResponse> {
        val service = mercadoPagoService.createCardToken(cardTokenBody)

        return ResponseToRequest.send(service)
    }

    override suspend fun createPayment(paymentBody: PaymentBody): Resource<PaymentResponse> {
        val service = mercadoPagoService.createPayment(paymentBody)
        Log.d("MercadoPagoRemoteDataSourceImpl", "createPayment: $service")
        return ResponseToRequest.send(service)
    }
}