package com.cranaya.domain.shoppingBag.usecase

import com.cranaya.domain.shoppingBag.repository.ShoppingBagRepository

class DeleteUseCase(private val shoppingBagRepository: ShoppingBagRepository) {
   suspend operator fun invoke(id: String) = shoppingBagRepository.delete(id)
}