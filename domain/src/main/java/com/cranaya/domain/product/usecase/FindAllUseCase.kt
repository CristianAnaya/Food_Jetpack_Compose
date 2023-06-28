package com.cranaya.domain.product.usecase

import com.cranaya.domain.product.model.Product
import com.cranaya.domain.product.repository.ProductsRepository
import java.io.File

class FindAllUseCase constructor(private val productsRepository: ProductsRepository) {
    suspend operator fun invoke() = productsRepository.findAll()
}