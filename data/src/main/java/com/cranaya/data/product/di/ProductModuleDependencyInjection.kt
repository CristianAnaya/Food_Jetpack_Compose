package com.cranaya.data.product.di

import com.cranaya.data.category.repository.dataSource.CategoriesRemoteDataSource
import com.cranaya.data.category.repository.dataSourceImpl.CategoriesRemoteDataSourceImpl
import com.cranaya.data.category.httpclient.service.CategoriesService
import com.cranaya.data.category.persistence.dao.CategoriesDao
import com.cranaya.data.product.repository.ProductRepositoryImpl
import com.cranaya.data.product.repository.dataSource.ProductsRemoteDataSource
import com.cranaya.data.product.repository.dataSourceImpl.ProductsRemoteDataSourceImpl
import com.cranaya.data.product.httpclient.service.ProductsService
import com.cranaya.data.product.persistence.dao.ProductsDao
import com.cranaya.data.product.repository.dataSource.ProductsLocalDataSource
import com.cranaya.data.product.repository.dataSourceImpl.ProductsLocalDataSourceImpl
import com.cranaya.data.shared.database.DeliveryDB
import com.cranaya.domain.product.repository.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductModuleDependencyInjection {

    @Provides
    @Singleton
    fun provideProductsDao(db: DeliveryDB): ProductsDao = db.productsDao()

    @Provides
    @Singleton
    fun provideProductService(retrofit: Retrofit): ProductsService {
        return retrofit.create(ProductsService::class.java)
    }

    @Provides
    fun provideProductLocalRemoteDataSource(
        productsDao: ProductsDao
    ): ProductsLocalDataSource = ProductsLocalDataSourceImpl(productsDao = productsDao)

    @Provides
    fun provideProductRemoteDataSource(
        productsService: ProductsService
    ): ProductsRemoteDataSource = ProductsRemoteDataSourceImpl(productsService = productsService)

    @Provides
    fun provideProductRepository(
        productsRemoteDataSource: ProductsRemoteDataSource,
        productsLocalDataSource: ProductsLocalDataSource
    ): ProductsRepository = ProductRepositoryImpl(
        productsRemoteDataSource = productsRemoteDataSource,
        productsLocalDataSource = productsLocalDataSource
    )

}
