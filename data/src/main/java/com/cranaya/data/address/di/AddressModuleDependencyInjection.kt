package com.cranaya.data.address.di

import com.cranaya.data.address.httpclient.service.AddressService
import com.cranaya.data.address.persistence.dao.AddressDao
import com.cranaya.data.address.repository.AddressRepositoryImpl
import com.cranaya.data.address.repository.dataSource.AddressLocalDataSource
import com.cranaya.data.address.repository.dataSource.AddressRemoteDataSource
import com.cranaya.data.address.repository.dataSourceImpl.AddressLocalDataSourceImpl
import com.cranaya.data.address.repository.dataSourceImpl.AddressRemoteDataSourceImpl
import com.cranaya.data.category.httpclient.service.CategoriesService
import com.cranaya.data.category.persistence.dao.CategoriesDao
import com.cranaya.data.category.repository.dataSource.CategoriesRemoteDataSource
import com.cranaya.data.category.repository.dataSourceImpl.CategoriesRemoteDataSourceImpl
import com.cranaya.data.shared.database.DeliveryDB
import com.cranaya.domain.address.repository.AddressRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AddressModuleDependencyInjection {

    @Provides
    @Singleton
    fun provideAddressDao(db: DeliveryDB): AddressDao = db.addressDao()

    @Provides
    @Singleton
    fun provideAddressService(retrofit: Retrofit): AddressService {
        return retrofit.create(AddressService::class.java)
    }

    @Provides
    fun provideAddressLocalDataSource(addressDao: AddressDao): AddressLocalDataSource
    = AddressLocalDataSourceImpl(addressDao = addressDao)

    @Provides
    fun provideAddressRemoteDataSource(addressService: AddressService): AddressRemoteDataSource
    = AddressRemoteDataSourceImpl(addressService = addressService)

    @Provides
    fun provideAddressRepository(
        addressLocalDataSource: AddressLocalDataSource,
        addressRemoteDataSource: AddressRemoteDataSource
    ): AddressRepository = AddressRepositoryImpl(
        addressLocalDataSource = addressLocalDataSource,
        addressRemoteDataSource = addressRemoteDataSource
    )

}
