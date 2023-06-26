package com.cranaya.data.product.mapper

import com.cranaya.data.product.httpclient.dto.ProductDto
import com.cranaya.data.product.persistence.entity.ProductEntity
import com.cranaya.domain.product.model.Product

fun Product.toProductDto(): ProductDto {
    return ProductDto(
        id,
        name,
        description,
        idCategory,
        image1,
        image2,
        price,
        imagesToUpdate
    )
}

fun ProductDto.toProduct(): Product {
    return Product(
        id,
        name,
        description,
        idCategory,
        image1,
        image2,
        price,
        imagesToUpdate
    )
}

fun Product.toProductEntity(): ProductEntity {
    return ProductEntity(
        id ?: "",
        name,
        description,
        idCategory,
        image1 ?: "",
        image2 ?: "",
        price
    )
}

fun ProductEntity.toProduct(): Product {
    return Product(
        id,
        name,
        description,
        idCategory,
        image1,
        image2,
        price,
        imagesToUpdate = null
    )
}