package com.cranaya.data.shared.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cranaya.data.category.persistence.dao.CategoriesDao
import com.cranaya.data.category.persistence.entity.CategoryEntity
import com.cranaya.data.product.persistence.dao.ProductsDao
import com.cranaya.data.product.persistence.entity.ProductEntity

@Database(
    entities = [CategoryEntity::class, ProductEntity::class],
    version = 2,
    exportSchema = false
)
abstract class DeliveryDB: RoomDatabase() {
    abstract fun categoriesDao(): CategoriesDao
    abstract fun productsDao(): ProductsDao
}