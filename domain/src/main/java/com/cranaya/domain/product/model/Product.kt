package com.cranaya.domain.product.model

import com.cranaya.domain.category.model.Category
import com.google.gson.Gson
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