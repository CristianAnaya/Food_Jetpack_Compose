package com.cranaya.data.category.di

import com.cranaya.data.auth.repository.AuthRepositoryImpl
import com.cranaya.data.auth.repository.dataSource.AuthRemoteDataSource
import com.cranaya.data.auth.repository.dataSource.AuthTemporalDataSource
import com.cranaya.data.auth.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.cranaya.data.auth.service.AuthService
import com.cranaya.data.category.persistence.dao.CategoriesDao
import com.cranaya.data.category.repository.CategoryRepositoryImpl
import com.cranaya.data.category.repository.dataSource.CategoriesLocalDataSource
import com.cranaya.data.category.repository.dataSource.CategoriesRemoteDataSource
import com.cranaya.data.category.repository.dataSourceImpl.CategoriesRemoteDataSourceImpl
import com.cranaya.data.category.repository.dataSourceImpl.CategoryLocalDataSourceImpl
import com.cranaya.data.category.service.CategoriesService
import com.cranaya.data.shared.database.DeliveryDB
import com.cranaya.domain.auth.repository.AuthRepository
import com.cranaya.domain.category.repository.CategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CategoryModuleDependencyInjection {

    @Provides
    @Singleton
    fun provideCategoriesDao(db: DeliveryDB): CategoriesDao = db.categoriesDao()

    @Provides
    @Singleton
    fun provideCategoryService(retrofit: Retrofit): CategoriesService {
        return retrofit.create(CategoriesService::class.java)
    }

    @Provides
    fun provideCategoryLocalDataSource(categoriesDao: CategoriesDao): CategoriesLocalDataSource
    = CategoryLocalDataSourceImpl(categoryDao = categoriesDao)

    @Provides
    fun provideCategoryRemoteDataSource(categoriesService: CategoriesService): CategoriesRemoteDataSource
    = CategoriesRemoteDataSourceImpl(categoriesService = categoriesService)

    @Provides
    fun provideCategoryRepository(
        categoriesRemoteDataSource: CategoriesRemoteDataSource,
        categoriesLocalDataSource: CategoriesLocalDataSource
    ): CategoryRepository = CategoryRepositoryImpl(
        categoriesRemoteDataSource = categoriesRemoteDataSource,
        categoriesLocalDataSource = categoriesLocalDataSource
    )

}