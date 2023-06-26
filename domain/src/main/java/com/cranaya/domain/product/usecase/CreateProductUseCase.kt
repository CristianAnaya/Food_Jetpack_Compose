package com.cranaya.domain.product.usecase

import com.cranaya.domain.product.model.Product
import com.cranaya.domain.product.repository.ProductsRepository
import java.io.File

class CreateProductUseCase constructor(private val productsRepository: ProductsRepository) {
    suspend operator fun invoke(product: Product, files: List<File>) = productsRepository.create(product, files)
}