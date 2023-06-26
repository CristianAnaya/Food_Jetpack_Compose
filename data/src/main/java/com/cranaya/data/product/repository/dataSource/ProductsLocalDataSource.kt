package com.cranaya.data.product.repository.dataSource

import com.cranaya.domain.product.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductsLocalDataSource {
    suspend fun create(product: Product)
    suspend fun insertAll(products: List<Product>)
    fun getProducts(): Flow<List<Product>>
    fun findByCategory(idCategory: String): Flow<List<Product>>
    suspend fun update(id: String, name: String, description: String, image1: String, image2: String, price: Double)
    suspend fun delete(id: String)
}