package com.cranaya.data.address.mapper

import com.cranaya.data.address.httpclient.dto.AddressDto
import com.cranaya.data.address.persistence.entity.AddressEntity
import com.cranaya.domain.address.model.Address

fun Address.toAddressDto(): AddressDto {
    return AddressDto(
        id = id,
        address = address,
        neighborhood = neighborhood,
        idUser = idUser
    )
}

fun AddressDto.toAddress(): Address {
    return Address(
        id = id,
        address = address,
        neighborhood = neighborhood,
        idUser = idUser
    )
}

fun AddressEntity.toAddress(): Address {
    return Address(
        id = id,
        address = address,
        neighborhood = neighborhood,
        idUser = idUser
    )
}

fun Address.toAddressEntity(): AddressEntity {
    return AddressEntity(
        id = id ?: "",
        address = address,
        neighborhood = neighborhood,
        idUser = idUser
    )
}