package com.cranaya.domain.category.usecase

import com.cranaya.domain.category.model.Category
import com.cranaya.domain.category.repository.CategoryRepository
import java.io.File

class GetCategoryUseCase(private val categoryRepository: CategoryRepository) {

    suspend operator fun invoke() = categoryRepository.getCategories()

}