package com.cranaya.data.shared.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cranaya.data.address.persistence.dao.AddressDao
import com.cranaya.data.address.persistence.entity.AddressEntity
import com.cranaya.data.category.persistence.dao.CategoriesDao
import com.cranaya.data.category.persistence.entity.CategoryEntity
import com.cranaya.data.product.persistence.dao.ProductsDao
import com.cranaya.data.product.persistence.entity.ProductEntity
import com.cranaya.data.shoppingBag.persistence.dao.ShoppingBagDao
import com.cranaya.data.shoppingBag.persistence.entity.ShoppingBagEntity

@Database(
    entities =
    [
        CategoryEntity::class,
        ProductEntity::class,
        ShoppingBagEntity::class,
        AddressEntity::class
    ],
    version = 4,
    exportSchema = false
)
abstract class DeliveryDB: RoomDatabase() {
    abstract fun categoriesDao(): CategoriesDao
    abstract fun productsDao(): ProductsDao
    abstract fun shoppingBagDao(): ShoppingBagDao
    abstract fun addressDao(): AddressDao
}