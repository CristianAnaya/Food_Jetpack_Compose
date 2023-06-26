package com.cranaya.inc.screens.admin.product.update.mapper

import com.cranaya.domain.product.model.Product
import com.cranaya.inc.screens.admin.product.create.AdminProductCreateState
import com.cranaya.inc.screens.admin.product.update.AdminProductUpdateState

fun AdminProductUpdateState.toProduct(): Product {
    return Product(
        name = name,
        description = description,
        idCategory = idCategory,
        price = price,
        imagesToUpdate = imagesToUpdate.toList(),
        image1 = image1,
        image2 = image2
    )
}