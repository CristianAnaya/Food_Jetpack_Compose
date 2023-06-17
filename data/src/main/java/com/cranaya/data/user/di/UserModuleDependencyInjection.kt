package com.cranaya.data.user.di

import com.cranaya.data.auth.repository.AuthRepositoryImpl
import com.cranaya.data.auth.repository.dataSource.AuthRemoteDataSource
import com.cranaya.data.auth.repository.dataSource.AuthTemporalDataSource
import com.cranaya.data.auth.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.cranaya.data.auth.service.AuthService
import com.cranaya.data.user.repository.UserRepositoryImpl
import com.cranaya.data.user.repository.dataSource.UserRemoteDataSource
import com.cranaya.data.user.repository.dataSourceImpl.UserRemoteDataSourceImpl
import com.cranaya.data.user.service.UserService
import com.cranaya.domain.auth.repository.AuthRepository
import com.cranaya.domain.user.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserModuleDependencyInjection {

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)
    }

    @Provides
    fun provideUserRemoteDataSource(userService: UserService): UserRemoteDataSource = UserRemoteDataSourceImpl(userService = userService)

    @Provides
    fun provideAuthRepository(
        userRemoteDataSource: UserRemoteDataSource,
    ): UserRepository = UserRepositoryImpl(
        userRemoteDataSource = userRemoteDataSource,
    )

}