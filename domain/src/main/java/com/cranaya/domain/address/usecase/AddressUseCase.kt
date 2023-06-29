package com.cranaya.domain.address.usecase

data class AddressUseCase(
    val createAddress: CreateAddressUseCase,
    val findByUserAddress: FindByUserAddressUseCase
)
