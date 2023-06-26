package com.cranaya.inc.screens.admin.product.create.mapper

import com.cranaya.domain.product.model.Product
import com.cranaya.inc.screens.admin.product.create.AdminProductCreateState

fun AdminProductCreateState.toProduct(): Product {
    return Product(
        name = name,
        description = description,
        idCategory = idCategory,
        price = price
    )
}