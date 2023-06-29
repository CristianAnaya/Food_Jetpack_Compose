package com.cranaya.data.address.repository.dataSource

import com.cranaya.data.category.persistence.entity.CategoryEntity
import com.cranaya.domain.address.model.Address
import com.cranaya.domain.category.model.Category
import kotlinx.coroutines.flow.Flow

interface AddressLocalDataSource {
    suspend fun create(address: Address)
    suspend fun insertAll(addressList: List<Address>)
    fun findByUser(idUser: String): Flow<List<Address>>
    suspend fun update(id: String, address: String, neighborhood: String)
    suspend fun delete(id: String)
}