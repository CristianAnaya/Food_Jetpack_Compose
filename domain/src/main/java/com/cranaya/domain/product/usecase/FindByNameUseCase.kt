package com.cranaya.domain.product.usecase

import com.cranaya.domain.product.model.Product
import com.cranaya.domain.product.repository.ProductsRepository
import java.io.File

class FindByNameUseCase constructor(private val productsRepository: ProductsRepository) {
    suspend operator fun invoke(name: String) = productsRepository.findByName(name)
}