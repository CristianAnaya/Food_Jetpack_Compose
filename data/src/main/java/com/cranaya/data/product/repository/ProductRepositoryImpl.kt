package com.cranaya.data.product.repository

import com.cranaya.data.product.repository.dataSource.ProductsLocalDataSource
import com.cranaya.data.product.repository.dataSource.ProductsRemoteDataSource
import com.cranaya.domain.product.model.Product
import com.cranaya.domain.product.repository.ProductsRepository
import com.cranaya.domain.shared.Resource
import com.cranaya.domain.shared.isListEqual
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.File
import java.lang.Exception

class ProductRepositoryImpl constructor(
    private val productsRemoteDataSource: ProductsRemoteDataSource,
    private val productsLocalDataSource: ProductsLocalDataSource
): ProductsRepository {

    override fun findAll(): Flow<Resource<List<Product>>> {
        TODO("Not yet implemented")
    }

    override fun findByCategory(idCategory: String): Flow<Resource<List<Product>>> = flow {
        productsLocalDataSource.findByCategory(idCategory).collect {
            it.run {
                val productsLocalMap = this
                try {
                    productsRemoteDataSource.findByCategory(idCategory).run {
                        when (this) {
                            is Resource.Success -> {
                                val productsRemote = this.data

                                if (!isListEqual(productsRemote, productsLocalMap)) {
                                    productsLocalDataSource.insertAll(productsRemote)
                                }

                                emit(Resource.Success(productsRemote))
                            }
                            else -> {
                                emit(Resource.Failure("Ocurrio un error desconocido"))
                                emit(Resource.Success(productsLocalMap))
                            }
                        }
                    }
                } catch (e: Exception) {
                    emit(Resource.Failure(e.message!!))
                    emit(Resource.Success(productsLocalMap))
                }
            }
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun create(product: Product, files: List<File>): Resource<Product> {
        return try {
            productsRemoteDataSource.create(product, files).run {
                return when(this) {
                    is Resource.Success -> {
                        productsLocalDataSource.create(this.data)
                        Resource.Success(this.data)
                    } else -> {
                        Resource.Failure("Ocurrio un error desconocido, por favor vuelvelo a intenrat")
                    }
                }
            }
        } catch (e: Exception) {
            Resource.Failure(e.message!!)
        }
    }

    override suspend fun updateWithImage(id: String, product: Product, files: List<File>?): Resource<Product> {
        return try {
            productsRemoteDataSource.updateWithImage(id, product, files).run {
                return when(this) {
                    is Resource.Success -> {
                        productsLocalDataSource.update(
                            this.data.id ?: "",
                            this.data.name,
                            this.data.description,
                            this.data.image1 ?: "",
                            this.data.image2 ?: "",
                            this.data.price
                        )
                        Resource.Success(this.data)
                    } else -> {
                        Resource.Failure("Ocurrio un error desconocido, por favor vuelvelo a intenrat")
                    }
                }
            }
        } catch (e: Exception) {
            Resource.Failure(e.message!!)
        }
    }

    override suspend fun update(id: String, product: Product): Resource<Product> {
        return try {
            productsRemoteDataSource.update(id, product).run {
                return when(this) {
                    is Resource.Success -> {
                        productsLocalDataSource.update(
                            this.data.id ?: "",
                            this.data.name,
                            this.data.description,
                            this.data.image1 ?: "",
                            this.data.image2 ?: "",
                            this.data.price
                        )
                        Resource.Success(this.data)
                    } else -> {
                        Resource.Failure("Ocurrio un error desconocido, por favor vuelvelo a intenrat")
                    }
                }
            }
        } catch (e: Exception) {
            Resource.Failure(e.message!!)
        }
    }

    override suspend fun delete(id: String): Resource<Unit> {
        return try {
            productsRemoteDataSource.delete(id).run {
                return when(this) {
                    is Resource.Success -> {
                        productsLocalDataSource.delete(id)
                        Resource.Success(Unit)
                    } else -> {
                        Resource.Failure("Ocurrio un error desconocido, por favor vuelvelo a intenrat")
                    }
                }
            }
        } catch (e: Exception) {
            Resource.Failure(e.message!!)
        }
    }
}