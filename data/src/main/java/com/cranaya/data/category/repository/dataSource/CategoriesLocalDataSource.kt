package com.cranaya.data.category.repository.dataSource

import com.cranaya.domain.category.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoriesLocalDataSource {
    suspend fun create(category: Category)
    suspend fun insertAll(categories: List<Category>)
    fun getCategories(): Flow<List<Category>>
    suspend fun update(id: String, name: String, description: String, image: String)
    suspend fun delete(id: String)
}