package com.cranaya.data.order.repository

import android.util.Log
import com.cranaya.data.order.repository.dataSource.OrderRemoteDataSource
import com.cranaya.domain.order.model.Order
import com.cranaya.domain.order.repository.OrderRepository
import com.cranaya.domain.shared.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OrderRepositoryImpl(private val orderRemoteDataSource: OrderRemoteDataSource): OrderRepository {

    override fun findAll(): Flow<Resource<List<Order>>> = flow {
        try {
            emit(orderRemoteDataSource.findAll())
        } catch (e: Exception){
            Log.d("OrderRepositoryImpl", "findAll: ${e.message}")
            emit(Resource.Failure(e.message!!))
        }
    }

    override fun findByClient(idClient: String): Flow<Resource<List<Order>>> = flow {
        try {
            emit(orderRemoteDataSource.findByClient(idClient))
        } catch (e: Exception){
            emit(Resource.Failure(e.message!!))
        }
    }

    override suspend fun updateStatus(id: String): Resource<Order> {
        return try {
            orderRemoteDataSource.updateStatus(id)
        } catch (e: Exception){
            Resource.Failure(e.message!!)
        }
    }

}