package com.cranaya.domain.category.usecase

data class CategoryUseCase(
    val createCategory: CreateCategoryUseCase,
    val getCategory: GetCategoryUseCase,
    val updateCategory: UpdateCategoryUseCase,
    val updateCategoryWithImage: UpdateCategoryWithImageUseCase,
    val deleteCategory: DeleteCategoryUseCase
)
