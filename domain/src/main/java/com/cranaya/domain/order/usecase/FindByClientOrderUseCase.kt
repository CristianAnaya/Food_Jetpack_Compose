package com.cranaya.domain.order.usecase

import com.cranaya.domain.order.repository.OrderRepository

class FindByClientOrderUseCase(private val orderRepository: OrderRepository) {

    operator fun invoke(idClient: String) = orderRepository.findByClient(idClient)

}