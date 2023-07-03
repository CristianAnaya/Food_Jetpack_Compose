package com.cranaya.domain.order.model

import com.cranaya.domain.address.model.Address
import com.cranaya.domain.address.model.AddressDto
import com.cranaya.domain.product.model.Product
import com.cranaya.domain.shoppingBag.model.ShoppingBag
import com.cranaya.domain.user.model.User
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Order(
    @SerializedName("id") val id: String? = null,
    @SerializedName("id_client") val idClient: String,
    @SerializedName("id_address") val idAddress: String,
    @SerializedName("user") val client: User? = null,
    @SerializedName("address") val address: AddressDto? = null,
    @SerializedName("status") val status: String? = null,
    @SerializedName("created_at") val createdAt: String? = null,
    @SerializedName("orderHasProducts") val orderHasProducts: List<OrderHasProducts>? = null,
    @SerializedName("products") val product: List<ShoppingBag>? = null
): Serializable {

    fun toJson(): String = Gson().toJson(Order(
        id,
        idClient,
        idAddress,
        User.fromJson(client?.toJson()!!),
        address,
        status,
        createdAt,
        orderHasProducts?.map { orderHasProducts -> OrderHasProducts.fromJson(orderHasProducts.toJson()) }
    ))

    companion object {
        fun fromJson(data: String): Order = Gson().fromJson(data, Order::class.java)
    }

}
