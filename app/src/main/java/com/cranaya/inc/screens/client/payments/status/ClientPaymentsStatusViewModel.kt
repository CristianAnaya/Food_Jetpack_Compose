package com.cranaya.inc.screens.client.payments.status

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.cranaya.domain.mercadopago.model.PaymentResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ClientPaymentsStatusViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    val data = savedStateHandle.get<String>("payment")
    var paymentResponse = PaymentResponse.fromJson(data!!)

}