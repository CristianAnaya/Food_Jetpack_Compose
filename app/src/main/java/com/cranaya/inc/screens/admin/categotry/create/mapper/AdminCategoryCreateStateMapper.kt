package com.cranaya.inc.screens.admin.categotry.create.mapper

import com.cranaya.domain.category.model.Category
import com.cranaya.inc.screens.admin.categotry.create.AdminCategoryCreateState

fun AdminCategoryCreateState.toCategory(): Category {
    return Category(
        name = name,
        description = description
    )
}