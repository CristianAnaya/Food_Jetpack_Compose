package com.cranaya.data.mercadopago.httpclient.service

import com.cranaya.domain.mercadopago.model.IdentificationType
import com.cranaya.domain.mercadopago.model.Installment
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MercadoPagoService {

    @GET("mercadopago/identification_types")
    suspend fun getIdentificationTypes(): Response<List<IdentificationType>>

    @GET("mercadopago/installments/{first_six_digits}/{amount}")
    suspend fun getInstallments(
        @Path("first_six_digits") firstSixDigits: Int,
        @Path("amount") amount: Double
    ): Response<Installment>
}