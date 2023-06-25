package com.cranaya.data.category.repository.dataSourceImpl

import com.cranaya.data.category.mapper.toCategory
import com.cranaya.data.category.mapper.toCategoryEntity
import com.cranaya.data.category.persistence.dao.CategoriesDao
import com.cranaya.data.category.repository.dataSource.CategoriesLocalDataSource
import com.cranaya.domain.category.model.Category
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class CategoryLocalDataSourceImpl constructor(private val categoryDao: CategoriesDao): CategoriesLocalDataSource {

    override suspend fun create(category: Category) = categoryDao.insert(category.toCategoryEntity())

    override suspend fun insertAll(categories: List<Category>) = categoryDao.insertAll(categories.map { it.toCategoryEntity() })

    override fun getCategories(): Flow<List<Category>> = categoryDao.getCategories().map { it.map { category -> category.toCategory() } }

    override suspend fun update(id: String, name: String, description: String, image: String) = categoryDao.update(id, name, description, image)

    override suspend fun delete(id: String) = categoryDao.delete(id)

}