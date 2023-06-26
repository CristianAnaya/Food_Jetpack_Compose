package com.cranaya.domain.product.usecase

import com.cranaya.domain.product.model.Product
import com.cranaya.domain.product.repository.ProductsRepository
import java.io.File

class UpdateProductUseCase constructor(private val productsRepository: ProductsRepository) {
    suspend operator fun invoke(id: String, product: Product) = productsRepository.update(id, product)
}