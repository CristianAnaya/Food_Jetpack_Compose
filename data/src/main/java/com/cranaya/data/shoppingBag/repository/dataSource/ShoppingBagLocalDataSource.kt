package com.cranaya.data.shoppingBag.repository.dataSource

import com.cranaya.domain.shoppingBag.model.ShoppingBag
import kotlinx.coroutines.flow.Flow

interface ShoppingBagLocalDataSource {
    suspend fun create(shoppingBag: ShoppingBag)
    suspend fun insertAll(shoppingBags: List<ShoppingBag>)
    fun finAll(): Flow<List<ShoppingBag>>
    suspend fun findById(id: String): ShoppingBag?
    suspend fun update(id: String, quantity: Int)
    suspend fun delete(id: String)
}