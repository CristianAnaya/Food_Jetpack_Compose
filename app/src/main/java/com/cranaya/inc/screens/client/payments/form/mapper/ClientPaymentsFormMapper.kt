package com.cranaya.inc.screens.client.payments.form.mapper

import com.cranaya.domain.mercadopago.model.CardTokenBody
import com.cranaya.domain.mercadopago.model.Cardholder
import com.cranaya.domain.mercadopago.model.Identification
import com.cranaya.inc.screens.client.payments.form.ClientPaymentsFormState

fun ClientPaymentsFormState.toCardTokenBody(): CardTokenBody {
    return CardTokenBody(
        cardNumber = cardNumber,
        expirationMonth = expirationMonth.toInt(),
        expirationYear = expirationYear,
        securityCode = securityCode,
        cardholder = Cardholder(
            name = name,
            identification = Identification(
                type = type,
                number = number
            )
        )
    )
}