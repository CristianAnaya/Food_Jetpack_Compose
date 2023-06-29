package com.cranaya.data.order.httpclient

import com.cranaya.domain.order.model.Order
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface OrderService {

    @GET("orders")
    suspend fun findAll(): Response<List<Order>>

    @GET("orders/{id_client}")
    suspend fun findByClient(@Path("id_client") idClient: String): Response<List<Order>>

    @PUT("orders/{id}")
    suspend fun updateStatus(@Path("id") id: String): Response<Order>
}