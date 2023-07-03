package com.cranaya.data.product.httpclient.service

import com.cranaya.data.product.httpclient.dto.ProductDto
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface ProductsService {

    @GET("products/category/{id_category}")
    suspend fun findByCategory(
        @Path("id_category") idCategory: String
    ): Response<List<ProductDto>>

    @GET("products/search/{name}")
    suspend fun findByName(
        @Path("name") name: String
    ): Response<List<ProductDto>>

    @GET("products}")
    suspend fun finAll(): Response<List<ProductDto>>

    @Multipart
    @POST("products")
    suspend fun create(
        @Part files: Array<MultipartBody.Part?>,
        @Part("name") name: RequestBody,
        @Part("description") description: RequestBody,
        @Part("id_category") idCategory: RequestBody,
        @Part("price") price: RequestBody
    ): Response<ProductDto>

    @Multipart
    @PUT("products/upload/{id}")
    suspend fun updateWithImage(
        @Part files: Array<MultipartBody.Part?>,
        @Path("id") id: String,
        @Part("name") name: RequestBody,
        @Part("description") description: RequestBody,
        @Part("id_category") idCategory: RequestBody,
        @Part("price") price: RequestBody,
        @Part("images_to_update[]") imagesToUpdate: Array<RequestBody?>
    ): Response<ProductDto>

    @PUT("products/{id}")
    suspend fun update(
        @Path("id") id: String,
        @Body productDto: ProductDto
    ): Response<ProductDto>

    @DELETE("products/{id}")
    suspend fun delete(
        @Path("id") id: String,
    ): Response<Unit>
}