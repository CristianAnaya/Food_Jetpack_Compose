package com.cranaya.data.mercadopago.di

import com.cranaya.data.mercadopago.httpclient.service.MercadoPagoService
import com.cranaya.data.mercadopago.repository.MercadoPagoRepositoryImpl
import com.cranaya.data.mercadopago.repository.dataSource.MercadoPagoRemoteDataSource
import com.cranaya.data.mercadopago.repository.dataSourceImpl.MercadoPagoRemoteDataSourceImpl
import com.cranaya.domain.mercadopago.repository.MercadoPagoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MercadoPagoModuleDependencyInjection {

    @Provides
    @Singleton
    fun provideMercadoPagoService(retrofit: Retrofit): MercadoPagoService {
        return retrofit.create(MercadoPagoService::class.java)
    }

    @Provides
    fun provideMercadoPagoRemoteDataSource(mercadoPagoService: MercadoPagoService): MercadoPagoRemoteDataSource
    = MercadoPagoRemoteDataSourceImpl(mercadoPagoService = mercadoPagoService)

    @Provides
    fun provideMercadoPagoRepository(mercadoPagoRemoteDataSource: MercadoPagoRemoteDataSource): MercadoPagoRepository
    = MercadoPagoRepositoryImpl(mercadoPagoRemoteDataSource = mercadoPagoRemoteDataSource)

}