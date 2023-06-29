package com.cranaya.data.address.repository.dataSource

import com.cranaya.domain.address.model.Address
import com.cranaya.domain.shared.Resource
import kotlinx.coroutines.flow.Flow

interface AddressRemoteDataSource {

    suspend fun create(address: Address): Resource<Address>
    suspend fun findByUser(idUser: String): Resource<List<Address>>
}