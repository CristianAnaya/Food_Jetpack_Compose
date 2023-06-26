package com.cranaya.data.category.mapper

import com.cranaya.data.category.httpclient.dto.CategoryDto
import com.cranaya.data.category.persistence.entity.CategoryEntity
import com.cranaya.domain.category.model.Category

fun CategoryDto.toCategory(): Category {
    return Category(
        id = id,
        name = name,
        description = description,
        image = image
    )
}

fun Category.toCategoryDto(): CategoryDto {
    return CategoryDto(
        id = id,
        name = name,
        description = description,
        image = image
    )
}

fun Category.toCategoryEntity(): CategoryEntity {
    return CategoryEntity(
        id = id ?: "",
        name = name,
        description = description,
        image = image ?: ""
    )
}

fun CategoryEntity.toCategory(): Category {
    return Category(
        id = id,
        name = name,
        description = description,
        image = image
    )
}