package com.cranaya.domain.order.model

import com.cranaya.domain.product.model.Product
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class OrderHasProducts(
    @SerializedName("id_order") val idOrder: String,
    @SerializedName("id_product") val idProduct: String,
    @SerializedName("quantity") val quantity: Int,
    @SerializedName("product") val product: Product
): Serializable
