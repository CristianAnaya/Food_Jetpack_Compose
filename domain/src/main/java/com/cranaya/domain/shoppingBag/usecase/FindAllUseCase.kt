package com.cranaya.domain.shoppingBag.usecase

import com.cranaya.domain.shoppingBag.repository.ShoppingBagRepository

class FindAllUseCase(private val shoppingBagRepository: ShoppingBagRepository) {
    operator fun invoke() = shoppingBagRepository.findAll()
}