package com.cranaya.domain.order.repository

import com.cranaya.domain.order.model.Order
import com.cranaya.domain.shared.Resource
import kotlinx.coroutines.flow.Flow

interface OrderRepository {

    fun findAll(): Flow<Resource<List<Order>>>
    fun findByClient(idClient: String): Flow<Resource<List<Order>>>
    suspend fun updateStatus(id: String): Resource<Order>

}