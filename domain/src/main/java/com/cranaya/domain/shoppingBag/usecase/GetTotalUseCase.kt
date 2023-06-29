package com.cranaya.domain.shoppingBag.usecase

import com.cranaya.domain.shoppingBag.repository.ShoppingBagRepository

class GetTotalUseCase(private val shoppingBagRepository: ShoppingBagRepository) {
    suspend operator fun invoke() = shoppingBagRepository.getTotal()
}