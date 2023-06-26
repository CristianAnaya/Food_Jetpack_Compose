package com.cranaya.domain.product.usecase

import com.cranaya.domain.product.model.Product
import com.cranaya.domain.product.repository.ProductsRepository
import java.io.File

class DeleteProductUseCase constructor(private val productsRepository: ProductsRepository) {
    suspend operator fun invoke(id: String) = productsRepository.delete(id)
}