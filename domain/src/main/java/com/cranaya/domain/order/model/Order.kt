package com.cranaya.domain.order.model

import com.cranaya.domain.product.model.Product
import com.cranaya.domain.shoppingBag.model.ShoppingBag
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Order(
    @SerializedName("id") val id: String? = null,
    @SerializedName("id_client") val idClient: String,
    @SerializedName("id_address") val idAddress: String,
    @SerializedName("status") val status: String? = null,
    @SerializedName("created_at") val createdAt: String? = null,
    @SerializedName("orderHasProducts") val orderHasProducts: List<OrderHasProducts>? = null,
    @SerializedName("products") val product: List<ShoppingBag>? = null
): Serializable
