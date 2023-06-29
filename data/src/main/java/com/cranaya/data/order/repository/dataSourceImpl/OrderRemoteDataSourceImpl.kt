package com.cranaya.data.order.repository.dataSourceImpl

import com.cranaya.data.order.httpclient.OrderService
import com.cranaya.data.order.repository.dataSource.OrderRemoteDataSource
import com.cranaya.data.shared.httpClient.config.ResponseToRequest
import com.cranaya.domain.order.model.Order
import com.cranaya.domain.shared.Resource

class OrderRemoteDataSourceImpl(private val orderService: OrderService): OrderRemoteDataSource {
    override suspend fun findAll(): Resource<List<Order>> {
        val service = orderService.findAll()
        return ResponseToRequest.send(service)
    }

    override suspend fun findByClient(idClient: String): Resource<List<Order>> {
        val service = orderService.findByClient(idClient)
        return ResponseToRequest.send(service)
    }

    override suspend fun updateStatus(id: String): Resource<Order> {
        val service = orderService.updateStatus(id)
        return ResponseToRequest.send(service)
    }
}