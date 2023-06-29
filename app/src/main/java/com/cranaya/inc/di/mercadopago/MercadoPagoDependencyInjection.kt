package com.cranaya.inc.di.mercadopago

import com.cranaya.domain.mercadopago.repository.MercadoPagoRepository
import com.cranaya.domain.mercadopago.usecase.CreateCardTokenUseCase
import com.cranaya.domain.mercadopago.usecase.CreatePaymentUseCase
import com.cranaya.domain.mercadopago.usecase.GetIdentificationTypeUseCase
import com.cranaya.domain.mercadopago.usecase.GetInstallmentsUseCase
import com.cranaya.domain.mercadopago.usecase.MercadoPagoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MercadoPagoDependencyInjection {

    @Provides
    fun provideMercadoPagoUseCase(
        mercadoPagoRepository: MercadoPagoRepository
    ) = MercadoPagoUseCase(
        getIdentificationType = GetIdentificationTypeUseCase(mercadoPagoRepository),
        getInstallments = GetInstallmentsUseCase(mercadoPagoRepository),
        createCardToken = CreateCardTokenUseCase(mercadoPagoRepository),
        createPayment = CreatePaymentUseCase(mercadoPagoRepository)
    )
}