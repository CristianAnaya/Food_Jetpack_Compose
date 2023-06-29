package com.cranaya.domain.address.usecase

import com.cranaya.domain.address.model.Address
import com.cranaya.domain.address.repository.AddressRepository

class FindByUserAddressUseCase(private val addressRepository: AddressRepository) {
    suspend operator fun invoke(idUser: String) = addressRepository.findByUser(idUser)
}