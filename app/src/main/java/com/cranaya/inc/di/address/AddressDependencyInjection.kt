package com.cranaya.inc.di.address

import com.cranaya.domain.address.repository.AddressRepository
import com.cranaya.domain.address.usecase.AddressUseCase
import com.cranaya.domain.address.usecase.CreateAddressUseCase
import com.cranaya.domain.address.usecase.FindByUserAddressUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AddressDependencyInjection {

    @Provides
    fun providesAddressUseCase(addressRepository: AddressRepository) = AddressUseCase(
        createAddress = CreateAddressUseCase(addressRepository),
        findByUserAddress = FindByUserAddressUseCase(addressRepository)
    )

}