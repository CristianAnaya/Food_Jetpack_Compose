package com.cranaya.inc.screens.client.address.create.mapper

import com.cranaya.domain.address.model.Address
import com.cranaya.inc.screens.client.address.create.ClientAddressCreateState

fun ClientAddressCreateState.toAddress(): Address {
    return Address(
        address = address,
        neighborhood = neighborhood,
        idUser = idUser
    )
}