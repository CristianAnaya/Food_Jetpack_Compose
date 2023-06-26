package com.cranaya.data.product.httpclient.dto

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable

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

    companion object {
        fun fromJson(data: String): ProductDto = Gson().fromJson(data, ProductDto::class.java)
    }

}
