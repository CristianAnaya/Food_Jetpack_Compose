package com.cranaya.domain.order.usecase

import com.cranaya.domain.order.repository.OrderRepository

class FindAllOrderUseCase(private val orderRepository: OrderRepository) {

    operator fun invoke() = orderRepository.findAll()

}