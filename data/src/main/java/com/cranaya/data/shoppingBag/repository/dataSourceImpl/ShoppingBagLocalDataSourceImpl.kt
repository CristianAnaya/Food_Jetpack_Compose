package com.cranaya.data.shoppingBag.repository.dataSourceImpl

import android.util.Log
import com.cranaya.data.shoppingBag.mapper.toShoppingBag
import com.cranaya.data.shoppingBag.mapper.toShoppingBagEntity
import com.cranaya.data.shoppingBag.persistence.dao.ShoppingBagDao
import com.cranaya.data.shoppingBag.repository.dataSource.ShoppingBagLocalDataSource
import com.cranaya.domain.shoppingBag.model.ShoppingBag
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ShoppingBagLocalDataSourceImpl(
    private val shoppingBagDao: ShoppingBagDao
): ShoppingBagLocalDataSource {

    override suspend fun create(shoppingBag: ShoppingBag) = shoppingBagDao.insert(shoppingBag.toShoppingBagEntity())

    override suspend fun insertAll(shoppingBags: List<ShoppingBag>) = shoppingBagDao.insertAll(shoppingBags.map { it.toShoppingBagEntity() })

    override suspend fun getTotal(): Double = shoppingBagDao.getTotal()

    override fun finAll(): Flow<List<ShoppingBag>> = shoppingBagDao.findAll().map { it.map { shoppingBagEntity -> shoppingBagEntity.toShoppingBag() } }

    override suspend fun findById(id: String): ShoppingBag? = shoppingBagDao.findById(id)?.toShoppingBag()

    override suspend fun update(id: String, quantity: Int) = shoppingBagDao.update(id, quantity)

    override suspend fun delete(id: String) = shoppingBagDao.delete(id)

}