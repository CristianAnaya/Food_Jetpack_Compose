package com.cranaya.domain.shoppingBag.usecase

import com.cranaya.domain.shoppingBag.model.ShoppingBag
import com.cranaya.domain.shoppingBag.repository.ShoppingBagRepository

class FindByIdUseCase(private val shoppingBagRepository: ShoppingBagRepository) {
    suspend operator fun invoke(id: String) = shoppingBagRepository.findById(id)
}