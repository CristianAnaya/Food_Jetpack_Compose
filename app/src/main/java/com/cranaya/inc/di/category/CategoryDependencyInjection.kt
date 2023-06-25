package com.cranaya.inc.di.category

import com.cranaya.domain.category.repository.CategoryRepository
import com.cranaya.domain.category.usecase.CategoryUseCase
import com.cranaya.domain.category.usecase.CreateCategoryUseCase
import com.cranaya.domain.category.usecase.DeleteCategoryUseCase
import com.cranaya.domain.category.usecase.GetCategoryUseCase
import com.cranaya.domain.category.usecase.UpdateCategoryUseCase
import com.cranaya.domain.category.usecase.UpdateCategoryWithImageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object CategoryDependencyInjection {

    @Provides
    fun providesCategoryUseCase(categoryRepository: CategoryRepository) = CategoryUseCase(
        createCategory = CreateCategoryUseCase(categoryRepository = categoryRepository),
        getCategory = GetCategoryUseCase(categoryRepository = categoryRepository),
        updateCategory = UpdateCategoryUseCase(categoryRepository = categoryRepository),
        updateCategoryWithImage = UpdateCategoryWithImageUseCase(categoryRepository = categoryRepository),
        deleteCategory = DeleteCategoryUseCase(categoryRepository = categoryRepository)
    )

}