package com.cranaya.domain.product.usecase

data class ProductUseCase(
    val createProduct: CreateProductUseCase,
    val findAll: FindAllUseCase,
    val findByCategory: FindByCategoryUseCase,
    val findByName: FindByNameUseCase,
    val updateProduct: UpdateProductUseCase,
    val updateProductWithImage: UpdateProductWithImageUseCase,
    val deleteProduct: DeleteProductUseCase
)
