package com.cranaya.inc.di.order

import com.cranaya.domain.order.repository.OrderRepository
import com.cranaya.domain.order.usecase.FindAllOrderUseCase
import com.cranaya.domain.order.usecase.FindByClientOrderUseCase
import com.cranaya.domain.order.usecase.OrdersUseCase
import com.cranaya.domain.order.usecase.UpdateStatusOrderUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object OrderDependencyInjection {

    @Provides
    fun provideOrderUseCase(
        orderRepository: OrderRepository
    ) = OrdersUseCase(
        findAllOrders = FindAllOrderUseCase(orderRepository),
        findByClientOrder = FindByClientOrderUseCase(orderRepository),
        updateStatusOrder = UpdateStatusOrderUseCase(orderRepository)
    )

}