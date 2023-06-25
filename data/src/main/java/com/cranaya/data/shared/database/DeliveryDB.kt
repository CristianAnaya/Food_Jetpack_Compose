package com.cranaya.data.shared.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cranaya.data.category.persistence.dao.CategoriesDao
import com.cranaya.data.category.persistence.entity.CategoryEntity

@Database(
    entities = [CategoryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class DeliveryDB: RoomDatabase() {
    abstract fun categoriesDao(): CategoriesDao
}