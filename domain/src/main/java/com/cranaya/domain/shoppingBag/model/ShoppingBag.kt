package com.cranaya.domain.shoppingBag.model

import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class ShoppingBag(
    val id: String,
    val name: String,
    val idCategory: String,
    val image1: String,
    val price: Double,
    var quantity: Int
) {

    fun toJson(): String = Gson().toJson(ShoppingBag(
        id,
        name,
        idCategory,
        if (!image1.isNullOrBlank()) URLEncoder.encode(image1, StandardCharsets.UTF_8.toString()) else "",
        price,
        quantity
    ))

    companion object {
        fun fromJson(data: String): ShoppingBag = Gson().fromJson(data, ShoppingBag::class.java)
    }

}
