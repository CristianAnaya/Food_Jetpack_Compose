package com.cranaya.inc.di.user

import com.cranaya.domain.user.repository.UserRepository
import com.cranaya.domain.user.usecase.UpdateUserUseCase
import com.cranaya.domain.user.usecase.UserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UserDependencyInjection {

    @Provides
    fun providesUserUseCase(userRepository: UserRepository) = UserUseCase(
        updateUser = UpdateUserUseCase(userRepository = userRepository)
    )

}