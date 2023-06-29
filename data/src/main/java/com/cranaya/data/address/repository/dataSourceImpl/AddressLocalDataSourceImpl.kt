package com.cranaya.data.address.repository.dataSourceImpl

import com.cranaya.data.address.mapper.toAddress
import com.cranaya.data.address.mapper.toAddressEntity
import com.cranaya.data.address.persistence.dao.AddressDao
import com.cranaya.data.address.repository.dataSource.AddressLocalDataSource
import com.cranaya.domain.address.model.Address
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AddressLocalDataSourceImpl(private val addressDao: AddressDao): AddressLocalDataSource {

    override suspend fun create(address: Address) = addressDao.insert(address.toAddressEntity())

    override suspend fun insertAll(addressList: List<Address>) = addressDao.insertAll(addressList.map { it.toAddressEntity() })

    override fun findByUser(idUser: String): Flow<List<Address>> = addressDao.findByUser(idUser).map { it.map { addressEntity -> addressEntity.toAddress() } }

    override suspend fun update(id: String, address: String, neighborhood: String) = addressDao.update(id, address, neighborhood)

    override suspend fun delete(id: String) = addressDao.delete(id)

}