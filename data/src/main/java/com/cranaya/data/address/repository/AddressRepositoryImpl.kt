package com.cranaya.data.address.repository

import com.cranaya.data.address.repository.dataSource.AddressLocalDataSource
import com.cranaya.data.address.repository.dataSource.AddressRemoteDataSource
import com.cranaya.domain.address.model.Address
import com.cranaya.domain.address.repository.AddressRepository
import com.cranaya.domain.shared.Resource
import com.cranaya.domain.shared.isListEqual
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AddressRepositoryImpl(
    private val addressLocalDataSource: AddressLocalDataSource,
    private val addressRemoteDataSource: AddressRemoteDataSource
): AddressRepository {

    override suspend fun create(address: Address): Resource<Address> {
        return try {
            addressRemoteDataSource.create(address).run {
                when(this) {
                    is Resource.Success -> {
                        addressLocalDataSource.create(this.data)
                        Resource.Success(this.data)
                    } else -> {
                        Resource.Failure("Ocurrio un erro desconocido")
                    }
                }
            }
        } catch (e: Exception) {
            Resource.Failure(e.message!!)
        }
    }

    override fun findByUser(idUser: String): Flow<Resource<List<Address>>> = flow {
        addressLocalDataSource.findByUser(idUser).collect {
            it.run {
                val addressLocalMap = this
                try {
                    addressRemoteDataSource.findByUser(idUser).run {
                        when (this) {
                            is Resource.Success -> {
                                val addressRemote = this.data

                                if (!isListEqual(addressRemote, addressLocalMap)) {
                                    addressLocalDataSource.insertAll(addressRemote)
                                }

                                emit(Resource.Success(addressRemote))
                            }
                            else -> {
                                emit(Resource.Failure("Ocurrio un error desconocido"))
                                emit(Resource.Success(addressLocalMap))
                            }
                        }
                    }
                } catch (e: Exception) {
                    emit(Resource.Failure(e.message!!))
                    emit(Resource.Success(addressLocalMap))
                }
            }
        }
    }.flowOn(Dispatchers.IO)

}