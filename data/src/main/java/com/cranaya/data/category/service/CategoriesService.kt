package com.cranaya.data.category.service

import com.cranaya.data.category.model.CategoryDto
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

interface CategoriesService {

    @GET("categories")
    suspend fun getCategories(): Response<List<CategoryDto>>

    @Multipart
    @POST("categories")
    suspend fun create(
        @Part file: MultipartBody.Part,
        @Part("name") name: RequestBody,
        @Part("description") description: RequestBody,
    ): Response<CategoryDto>

    @PUT("categories/{id}")
    suspend fun update(
        @Path("id") id: String,
        @Body category: CategoryDto
    ): Response<CategoryDto>

    @Multipart
    @PUT("categories/upload/{id}")
    suspend fun updateWithImage(
        @Part file: MultipartBody.Part,
        @Path("id") id: String,
        @Part("name") name: RequestBody,
        @Part("description") description: RequestBody,
    ): Response<CategoryDto>


    @DELETE("categories/{id}")
    suspend fun delete(
        @Path("id") id: String,
    ): Response<Unit>

}