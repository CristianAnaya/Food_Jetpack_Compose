package com.cranaya.domain.address.repository

import com.cranaya.domain.address.model.Address
import com.cranaya.domain.shared.Resource
import kotlinx.coroutines.flow.Flow

interface AddressRepository {

    suspend fun create(address: Address): Resource<Address>
    fun findByUser(idUser: String): Flow<Resource<List<Address>>>

}