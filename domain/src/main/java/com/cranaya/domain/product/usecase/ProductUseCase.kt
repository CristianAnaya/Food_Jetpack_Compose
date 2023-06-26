package com.cranaya.domain.product.usecase

data class ProductUseCase(
    val createProduct: CreateProductUseCase,
    val findByCategory: FindByCategoryUseCase,
    val updateProduct: UpdateProductUseCase,
    val updateProductWithImage: UpdateProductWithImageUseCase,
    val deleteProduct: DeleteProductUseCase
)
