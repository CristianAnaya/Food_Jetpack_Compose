package com.cranaya.inc.di.shoppingBag


import com.cranaya.domain.shoppingBag.repository.ShoppingBagRepository
import com.cranaya.domain.shoppingBag.usecase.AddUseCase
import com.cranaya.domain.shoppingBag.usecase.DeleteUseCase
import com.cranaya.domain.shoppingBag.usecase.FindAllUseCase
import com.cranaya.domain.shoppingBag.usecase.FindByIdUseCase
import com.cranaya.domain.shoppingBag.usecase.GetTotalUseCase
import com.cranaya.domain.shoppingBag.usecase.ShoppingBagUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ShoppingBagDependencyInjection {

    @Provides
    fun providesShoppingBagUseCase(shoppingBagRepository: ShoppingBagRepository) = ShoppingBagUseCase(
        add = AddUseCase(shoppingBagRepository),
        findAll = FindAllUseCase(shoppingBagRepository),
        delete = DeleteUseCase(shoppingBagRepository),
        findById = FindByIdUseCase(shoppingBagRepository),
        getTotal = GetTotalUseCase(shoppingBagRepository)
    )

}