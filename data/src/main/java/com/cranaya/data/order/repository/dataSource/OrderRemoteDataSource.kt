package com.cranaya.data.order.repository.dataSource

import com.cranaya.domain.order.model.Order
import com.cranaya.domain.shared.Resource

interface OrderRemoteDataSource {
    suspend fun findAll(): Resource<List<Order>>
    suspend fun findByClient(idClient: String): Resource<List<Order>>
    suspend fun updateStatus(id: String): Resource<Order>
}