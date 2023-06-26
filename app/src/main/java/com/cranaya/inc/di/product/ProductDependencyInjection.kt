package com.cranaya.inc.di.product

import com.cranaya.domain.product.repository.ProductsRepository
import com.cranaya.domain.product.usecase.CreateProductUseCase
import com.cranaya.domain.product.usecase.DeleteProductUseCase
import com.cranaya.domain.product.usecase.FindByCategoryUseCase
import com.cranaya.domain.product.usecase.ProductUseCase
import com.cranaya.domain.product.usecase.UpdateProductUseCase
import com.cranaya.domain.product.usecase.UpdateProductWithImageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ProductDependencyInjection {

    @Provides
    fun providesProductUseCase(productsRepository: ProductsRepository) = ProductUseCase(
        createProduct = CreateProductUseCase(productsRepository = productsRepository),
        findByCategory = FindByCategoryUseCase(productsRepository = productsRepository),
        updateProduct = UpdateProductUseCase(productsRepository = productsRepository),
        updateProductWithImage = UpdateProductWithImageUseCase(productsRepository = productsRepository),
        deleteProduct = DeleteProductUseCase(productsRepository = productsRepository)
    )

}