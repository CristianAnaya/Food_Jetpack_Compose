package com.cranaya.domain.category.usecase

import com.cranaya.domain.category.model.Category
import com.cranaya.domain.category.repository.CategoryRepository
import java.io.File

class UpdateCategoryUseCase(private val categoryRepository: CategoryRepository) {

    suspend operator fun invoke(id: String, category: Category) = categoryRepository.update(id, category)

}