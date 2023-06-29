package com.cranaya.data.order.di

import com.cranaya.data.category.httpclient.service.CategoriesService
import com.cranaya.data.category.repository.dataSource.CategoriesRemoteDataSource
import com.cranaya.data.category.repository.dataSourceImpl.CategoriesRemoteDataSourceImpl
import com.cranaya.data.order.httpclient.OrderService
import com.cranaya.data.order.repository.OrderRepositoryImpl
import com.cranaya.data.order.repository.dataSource.OrderRemoteDataSource
import com.cranaya.data.order.repository.dataSourceImpl.OrderRemoteDataSourceImpl
import com.cranaya.domain.order.repository.OrderRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OrderModuleDependencyInjection {

    @Provides
    @Singleton
    fun provideOrderService(retrofit: Retrofit): OrderService {
        return retrofit.create(OrderService::class.java)
    }

    @Provides
    fun provideOrderRemoteDataSource(orderService: OrderService): OrderRemoteDataSource
    = OrderRemoteDataSourceImpl(orderService = orderService)

    @Provides
    fun provideOrderRepository(orderRemoteDataSource: OrderRemoteDataSource): OrderRepository
    = OrderRepositoryImpl(orderRemoteDataSource = orderRemoteDataSource)

}