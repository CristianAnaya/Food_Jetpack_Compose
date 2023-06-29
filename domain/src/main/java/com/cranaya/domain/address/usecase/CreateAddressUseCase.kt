package com.cranaya.domain.address.usecase

import com.cranaya.domain.address.model.Address
import com.cranaya.domain.address.repository.AddressRepository

class CreateAddressUseCase(private val addressRepository: AddressRepository) {
    suspend operator fun invoke(address: Address) = addressRepository.create(address)
}