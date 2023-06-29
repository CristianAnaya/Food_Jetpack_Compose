package com.cranaya.data.address.httpclient.service

import com.cranaya.data.address.httpclient.dto.AddressDto
import com.cranaya.domain.address.model.Address
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AddressService {

    @GET("address/user/{id_user}")
    suspend fun findByUser(@Path("id_user") idUser: String): Response<List<AddressDto>>

    @POST("address")
    suspend fun create(@Body address: AddressDto): Response<AddressDto>

}