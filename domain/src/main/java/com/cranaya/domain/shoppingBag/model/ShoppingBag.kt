package com.cranaya.domain.shoppingBag.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class ShoppingBag(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("id_category") val idCategory: String,
    @SerializedName("image1") val image1: String,
    @SerializedName("price") val price: Double,
    @SerializedName("quantity") var quantity: Int,
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
