package com.cranaya.data.shoppingBag.di

import com.cranaya.data.shared.database.DeliveryDB
import com.cranaya.data.shoppingBag.persistence.dao.ShoppingBagDao
import com.cranaya.data.shoppingBag.repository.ShoppingBagRepositoryImpl
import com.cranaya.data.shoppingBag.repository.dataSource.ShoppingBagLocalDataSource
import com.cranaya.data.shoppingBag.repository.dataSourceImpl.ShoppingBagLocalDataSourceImpl
import com.cranaya.domain.shoppingBag.repository.ShoppingBagRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ShoppingBagModuleDependencyInjection {

    @Provides
    @Singleton
    fun provideProductsDao(db: DeliveryDB): ShoppingBagDao = db.shoppingBagDao()

    @Provides
    fun provideShoppingBagLocalRemoteDataSource(
        shoppingBagDao: ShoppingBagDao
    ): ShoppingBagLocalDataSource = ShoppingBagLocalDataSourceImpl(shoppingBagDao = shoppingBagDao)

    @Provides
    fun provideShoppingBagRepository(
        shoppingBagLocalDataSource: ShoppingBagLocalDataSource
    ): ShoppingBagRepository = ShoppingBagRepositoryImpl(
        shoppingBagLocalDataSource = shoppingBagLocalDataSource
    )

}