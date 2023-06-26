package com.cranaya.domain.product.repository

import com.cranaya.domain.product.model.Product
import com.cranaya.domain.shared.Resource
import kotlinx.coroutines.flow.Flow
import java.io.File

interface ProductsRepository {
    fun findAll(): Flow<Resource<List<Product>>>
    fun findByCategory(idCategory: String): Flow<Resource<List<Product>>>
    suspend fun create(product: Product, files: List<File>): Resource<Product>
    suspend fun updateWithImage(id: String, product: Product, files: List<File>?): Resource<Product>
    suspend fun update(id: String, product: Product): Resource<Product>
    suspend fun delete(id: String): Resource<Unit>
}