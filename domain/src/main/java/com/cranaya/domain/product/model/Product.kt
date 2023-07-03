package com.cranaya.domain.product.model

import com.cranaya.domain.category.model.Category
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class Product(
    val id: String? = null,
    val name: String,
    val description: String,
    val idCategory: String,
    val image1: String? = null,
    val image2: String? = null,
    val price: Double,
    val imagesToUpdate: List<Int>? = listOf()
) {

    fun toJson(): String = Gson().toJson(Product(
        id,
        name,
        description,
        idCategory,
        if (!image1.isNullOrBlank()) URLEncoder.encode(image1, StandardCharsets.UTF_8.toString()) else "",
        if (!image2.isNullOrBlank()) URLEncoder.encode(image2, StandardCharsets.UTF_8.toString()) else "",
        price,
        imagesToUpdate
    ))

    companion object {
        fun fromJson(data: String): Product = Gson().fromJson(data, Product::class.java)
    }

}

data class ProductDto(
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("id_category") val idCategory: String,
    @SerializedName("image1") val image1: String? = null,
    @SerializedName("image2") val image2: String? = null,
    @SerializedName("price") val price: Double,
    @SerializedName("images_to_update") val imagesToUpdate: List<Int>? = listOf()

): Serializable {

    fun toJson(): String = Gson().toJson(ProductDto(
        id,
        name,
        description,
        idCategory,
        if (!image1.isNullOrBlank()) URLEncoder.encode(image1, StandardCharsets.UTF_8.toString()) else "",
        if (!image2.isNullOrBlank()) URLEncoder.encode(image2, StandardCharsets.UTF_8.toString()) else "",
        price,
        imagesToUpdate
    ))

    companion object {
        fun fromJson(data: String): ProductDto = Gson().fromJson(data, ProductDto::class.java)
    }

}
