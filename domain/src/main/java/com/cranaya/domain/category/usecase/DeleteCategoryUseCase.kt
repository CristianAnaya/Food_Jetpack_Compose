package com.cranaya.domain.category.usecase

import com.cranaya.domain.category.model.Category
import com.cranaya.domain.category.repository.CategoryRepository
import java.io.File

class DeleteCategoryUseCase(private val categoryRepository: CategoryRepository) {

    suspend operator fun invoke(id: String) = categoryRepository.delete(id)

}