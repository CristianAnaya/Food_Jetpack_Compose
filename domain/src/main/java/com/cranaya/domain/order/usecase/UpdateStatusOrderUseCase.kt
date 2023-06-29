package com.cranaya.domain.order.usecase

import com.cranaya.domain.order.repository.OrderRepository

class UpdateStatusOrderUseCase(private val orderRepository: OrderRepository) {

    suspend operator fun invoke(id: String) = orderRepository.updateStatus(id)

}