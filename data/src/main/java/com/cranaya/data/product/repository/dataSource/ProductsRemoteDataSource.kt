package com.cranaya.data.product.repository.dataSource

import com.cranaya.domain.product.model.Product
import com.cranaya.domain.shared.Resource
import kotlinx.coroutines.flow.Flow
import java.io.File

interface ProductsRemoteDataSource {
    suspend fun findAll(): Resource<List<Product>>
    suspend fun findByCategory(idCategory: String): Resource<List<Product>>
    suspend fun create(product: Product, files: List<File>): Resource<Product>
    suspend fun updateWithImage(id: String, product: Product, files: List<File>?): Resource<Product>
    suspend fun update(id: String, product: Product): Resource<Product>
    suspend fun delete(id: String): Resource<Unit>
}