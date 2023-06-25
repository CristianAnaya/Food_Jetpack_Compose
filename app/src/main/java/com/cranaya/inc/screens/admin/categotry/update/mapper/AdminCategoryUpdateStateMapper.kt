package com.cranaya.inc.screens.admin.categotry.update.mapper

import com.cranaya.domain.category.model.Category
import com.cranaya.inc.screens.admin.categotry.create.AdminCategoryCreateState
import com.cranaya.inc.screens.admin.categotry.update.AdminCategoryUpdateState

fun AdminCategoryUpdateState.toCategory(): Category {
    return Category(
        name = name,
        description = description
    )
}