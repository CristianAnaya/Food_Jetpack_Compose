package com.cranaya.data.category.repository

import android.util.Log
import com.cranaya.data.category.mapper.toCategory
import com.cranaya.data.category.mapper.toCategoryEntity
import com.cranaya.data.category.repository.dataSource.CategoriesLocalDataSource
import com.cranaya.data.category.repository.dataSource.CategoriesRemoteDataSource
import com.cranaya.data.shared.httpClient.config.ResponseToRequest
import com.cranaya.domain.category.model.Category
import com.cranaya.domain.category.repository.CategoryRepository
import com.cranaya.domain.shared.Resource
import com.cranaya.domain.shared.isListEqual
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import java.io.File
import java.lang.Exception

class CategoryRepositoryImpl(
    private val categoriesRemoteDataSource: CategoriesRemoteDataSource,
    private val categoriesLocalDataSource: CategoriesLocalDataSource
): CategoryRepository {

    override suspend fun create(category: Category, file: File): Resource<Category> {
        categoriesRemoteDataSource.create(category = category, file = file).run {
            return when(this) {
                is Resource.Success -> {
                    categoriesLocalDataSource.create(this.data)
                    Resource.Success(this.data)
                } else -> {
                    Resource.Failure("Ocurrio un error desconocido, por favor vuelvelo a internar")
                }
            }
        }
    }

    override fun getCategories(): Flow<Resource<List<Category>>> = flow {
        categoriesLocalDataSource.getCategories().collect {
            it.run {
                val categoriesLocal = this
                try {
                    categoriesRemoteDataSource.getCategories().run {
                        when (this) {
                            is Resource.Success -> {
                                val categoriesRemote = this.data
                                if (!isListEqual(categoriesRemote, categoriesLocal)) {
                                    categoriesLocalDataSource.insertAll(categoriesRemote)
                                }
                                emit(Resource.Success(categoriesRemote))
                            }
                            is Resource.Failure -> {
                                emit(Resource.Success(categoriesLocal))
                            }
                            else -> {
                                emit(Resource.Success(categoriesLocal))
                            }
                        }
                    }
                } catch (e: Exception) {
                    emit(Resource.Success(categoriesLocal))
                }
            }
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun update(id: String, category: Category): Resource<Category> {
        categoriesRemoteDataSource.update(id, category).run {
            return when(this) {
                is Resource.Success -> {
                    categoriesLocalDataSource.update(this.data.id ?: "", this.data.name, this.data.description, this.data.image ?: "")
                    Resource.Success(this.data)
                } else -> {
                    Resource.Failure("Ocurrio un error desconocido, por favor vuelvelo a internar")
                }
            }
        }
    }

    override suspend fun updateWithImage(
        id: String,
        category: Category,
        file: File
    ): Resource<Category> = categoriesRemoteDataSource.updateWithImage(id, category, file)

    override suspend fun delete(id: String): Resource<Unit> {
        categoriesRemoteDataSource.delete(id).run {
            return when(this) {
                is Resource.Success -> {
                    categoriesLocalDataSource.delete(id)
                    Resource.Success(Unit)
                } else -> {
                    Resource.Failure("Ocurrio un error desconocido, por favor vuelvelo a internar")
                }
            }
        }
    }

}