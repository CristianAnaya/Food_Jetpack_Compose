package com.cranaya.domain.order.usecase

data class OrdersUseCase(
    val findAllOrders: FindAllOrderUseCase,
    val findByClientOrder: FindByClientOrderUseCase,
    val updateStatusOrder: UpdateStatusOrderUseCase
)
