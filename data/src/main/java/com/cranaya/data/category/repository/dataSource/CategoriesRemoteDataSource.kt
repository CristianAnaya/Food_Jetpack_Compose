package com.cranaya.data.category.repository.dataSource

import com.cranaya.domain.category.model.Category
import com.cranaya.domain.shared.Resource
import kotlinx.coroutines.flow.Flow
import java.io.File

interface CategoriesRemoteDataSource {
    suspend fun create(category: Category, file: File): Resource<Category>
    suspend fun getCategories(): Resource<List<Category>>
    suspend fun update(id: String, category: Category): Resource<Category>
    suspend fun updateWithImage(id: String, category: Category, file: File): Resource<Category>
    suspend fun delete(id: String): Resource<Unit>
}