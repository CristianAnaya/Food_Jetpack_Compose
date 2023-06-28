package com.cranaya.domain.shoppingBag.usecase

import com.cranaya.domain.shoppingBag.model.ShoppingBag
import com.cranaya.domain.shoppingBag.repository.ShoppingBagRepository

class AddUseCase(private val shoppingBagRepository: ShoppingBagRepository) {
   suspend operator fun invoke(shoppingBag: ShoppingBag) = shoppingBagRepository.add(shoppingBag)
}