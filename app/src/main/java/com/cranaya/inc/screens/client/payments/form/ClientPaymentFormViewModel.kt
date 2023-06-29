package com.cranaya.inc.screens.client.payments.form

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cranaya.domain.mercadopago.model.IdentificationType
import com.cranaya.domain.mercadopago.model.Installment
import com.cranaya.domain.mercadopago.usecase.MercadoPagoUseCase
import com.cranaya.domain.shared.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientPaymentFormViewModel @Inject constructor(private val mercadoPagoUseCase: MercadoPagoUseCase) : ViewModel() {

    var state by mutableStateOf(ClientPaymentsFormState())
        private set

    var identificationTypeResponse by mutableStateOf<Resource<List<IdentificationType>>?>(null)
        private set

    var installmentsResponse by mutableStateOf<Resource<Installment>?>(null)
        private set

    fun getIdentificationTypes() = viewModelScope.launch {
        identificationTypeResponse = Resource.Loading
        val result = mercadoPagoUseCase.getIdentificationType().first()
        identificationTypeResponse = result
        Log.d("ClientPaymentFormViewModel", "getIdentificationTypes: $identificationTypeResponse")
    }

    fun getInstallments(firstSixDigits: Int, amount: Double) = viewModelScope.launch {
        installmentsResponse = Resource.Loading
        val result = mercadoPagoUseCase.getInstallments(firstSixDigits, amount).first()
        installmentsResponse = result
        Log.d("ClientPaymentFormViewModel", "getInstallments: $installmentsResponse")
    }

    fun onCardNumberInput(input: String) {
        state = state.copy(cardNumber = input)
    }

    fun onExpirationYearInput(input: String) {
        state = state.copy(expirationYear = input)
    }

    fun onExpirationMonthInput(input: String) {
        state = state.copy(expirationMonth = input)
    }

    fun onSecurityCodeInput(input: String) {
        state = state.copy(securityCode = input)
    }

    fun onNameInput(input: String) {
        state = state.copy(name = input)
    }

    fun onIdentificationTypeInput(input: String) {
        state = state.copy(type = input)
    }

    fun onIdentificationNumberInput(input: String) {
        state = state.copy(number = input)
    }
}