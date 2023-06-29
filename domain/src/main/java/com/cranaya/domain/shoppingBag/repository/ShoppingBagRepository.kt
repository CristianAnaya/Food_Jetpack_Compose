package com.cranaya.domain.shoppingBag.repository

import com.cranaya.domain.shared.Resource
import com.cranaya.domain.shoppingBag.model.ShoppingBag
import kotlinx.coroutines.flow.Flow

interface ShoppingBagRepository {
    suspend fun add(shoppingBag: ShoppingBag)
    suspend fun delete(id: String)
    suspend fun getTotal(): Double
    fun findAll(): Flow<List<ShoppingBag>>
    suspend fun findById(id: String): ShoppingBag?
}