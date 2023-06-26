package com.cranaya.data.product.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cranaya.data.product.persistence.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(productEntity: ProductEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(productEntity: List<ProductEntity>)

    @Query("SELECT * FROM products")
    fun getProducts(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM products WHERE id_category = :idCategory")
    fun findByCategory(idCategory: String): Flow<List<ProductEntity>>

    @Query("UPDATE products SET name = :name, description = :description, image1 = :image1, image2 = :image2, price = :price WHERE id = :id")
    suspend fun update(id: String, name: String, description: String, image1: String, image2: String, price: Double)

    @Query("DELETE FROM products WHERE id = :id")
    suspend fun delete(id: String)

}