package com.cranaya.data.shared.database

import android.app.Application
import androidx.room.Room
import com.cranaya.data.category.persistence.dao.CategoriesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModuleDependencyInjection {

    @Provides
    fun provideDatabase(app: Application): DeliveryDB = Room.databaseBuilder(
        app, DeliveryDB::class.java,
        "delivery_db"
    ).fallbackToDestructiveMigration().build()

}