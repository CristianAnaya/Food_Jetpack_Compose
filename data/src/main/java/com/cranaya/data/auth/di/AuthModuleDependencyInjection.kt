package com.cranaya.data.auth.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.cranaya.data.auth.repository.AuthRepositoryImpl
import com.cranaya.data.auth.repository.dataSource.AuthRemoteDataSource
import com.cranaya.data.auth.repository.dataSource.AuthTemporalDataSource
import com.cranaya.data.auth.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.cranaya.data.auth.repository.dataSourceImpl.AuthTemporalDataSourceImpl
import com.cranaya.data.auth.service.AuthService
import com.cranaya.domain.auth.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AuthModuleDependencyInjection {

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthDataStore(dataStore: DataStore<Preferences>): AuthTemporalDataSource = AuthTemporalDataSourceImpl(dataStore)

    @Provides
    fun provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource = AuthRemoteDataSourceImpl(authService = authService)

    @Provides
    fun provideAuthRepository(
        authRemoteDataSource: AuthRemoteDataSource,
        authTemporalDataSource: AuthTemporalDataSource
    ): AuthRepository = AuthRepositoryImpl(
        authRemoteDataSource = authRemoteDataSource,
        authTemporalDataSource = authTemporalDataSource
    )

}