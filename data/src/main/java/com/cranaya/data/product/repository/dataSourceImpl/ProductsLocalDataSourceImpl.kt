package com.cranaya.data.product.repository.dataSourceImpl


import com.cranaya.data.product.mapper.toProduct
import com.cranaya.data.product.mapper.toProductEntity
import com.cranaya.data.product.persistence.dao.ProductsDao
import com.cranaya.data.product.repository.dataSource.ProductsLocalDataSource
import com.cranaya.domain.product.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProductsLocalDataSourceImpl constructor(private val productsDao: ProductsDao): ProductsLocalDataSource {

    override suspend fun create(product: Product) = productsDao.insert(product.toProductEntity())

    override suspend fun insertAll(products: List<Product>) = productsDao.insertAll(products.map { it.toProductEntity() })

    override fun getProducts(): Flow<List<Product>> = productsDao.getProducts().map { it.map { productEntity -> productEntity.toProduct() } }

    override fun findByCategory(
        idCategory: String
    ): Flow<List<Product>> = productsDao.findByCategory(idCategory).map { it.map { productEntity -> productEntity.toProduct() } }

    override suspend fun update(id: String, name: String, description: String, image1: String, image2: String, price: Double)
    = productsDao.update(id, name, description, image1, image2, price)

    override suspend fun delete(id: String) = productsDao.delete(id)

}