package com.cranaya.data.shoppingBag.mapper

import android.util.Log
import com.cranaya.data.shoppingBag.persistence.entity.ShoppingBagEntity
import com.cranaya.domain.shoppingBag.model.ShoppingBag

fun ShoppingBag.toShoppingBagEntity(): ShoppingBagEntity {
    return ShoppingBagEntity(
        id,
        name,
        idCategory,
        image1,
        price,
        quantity
    )
}

fun ShoppingBagEntity.toShoppingBag(): ShoppingBag {
    Log.d("toShoppingBag", "toShoppingBag: $id, $name, $idCategory, $image1, $price, $quantity")
    return ShoppingBag(
        id ?: "",
        name ?: "",
        idCategory ?: "",
        image1 ?: "",
        price ?: 0.0,
        quantity ?: 0
    )
}