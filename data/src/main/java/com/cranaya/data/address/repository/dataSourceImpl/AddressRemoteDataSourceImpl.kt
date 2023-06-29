package com.cranaya.data.address.repository.dataSourceImpl

import com.cranaya.data.address.httpclient.service.AddressService
import com.cranaya.data.address.mapper.toAddress
import com.cranaya.data.address.mapper.toAddressDto
import com.cranaya.data.address.repository.dataSource.AddressRemoteDataSource
import com.cranaya.data.shared.httpClient.config.ResponseToRequest
import com.cranaya.domain.address.model.Address
import com.cranaya.domain.shared.Resource

class AddressRemoteDataSourceImpl(private val addressService: AddressService): AddressRemoteDataSource {

    override suspend fun create(address: Address): Resource<Address> {
        val service = addressService.create(address.toAddressDto())
        return ResponseToRequest.send(service) {
            it.toAddress()
        }
    }

    override suspend fun findByUser(idUser: String): Resource<List<Address>> {
        val service = addressService.findByUser(idUser)
        return ResponseToRequest.send(service) {
            it.map { addressDto -> addressDto.toAddress() }
        }
    }

}