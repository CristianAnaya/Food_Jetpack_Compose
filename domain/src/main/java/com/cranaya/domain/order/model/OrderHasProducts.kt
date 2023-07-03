package com.cranaya.domain.order.model

import com.cranaya.domain.product.model.Product
import com.cranaya.domain.product.model.ProductDto
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class OrderHasProducts(
    @SerializedName("id_order") val idOrder: String,
    @SerializedName("id_product") val idProduct: String,
    @SerializedName("quantity") val quantity: Int,
    @SerializedName("product") val product: ProductDto
): Serializable {

    fun toJson(): String = Gson().toJson(OrderHasProducts(
        idOrder,
        idProduct,
        quantity,
        ProductDto.fromJson(product.toJson())
    ))

    companion object {
        fun fromJson(data: String): OrderHasProducts = Gson().fromJson(data, OrderHasProducts::class.java)
    }

}