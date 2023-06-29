package com.cranaya.inc.screens.client.payments.installments

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cranaya.domain.auth.usecase.AuthUseCase
import com.cranaya.domain.mercadopago.model.CardTokenBody
import com.cranaya.domain.mercadopago.model.CardTokenResponse
import com.cranaya.domain.mercadopago.model.Identification
import com.cranaya.domain.mercadopago.model.Installment
import com.cranaya.domain.mercadopago.model.Payer
import com.cranaya.domain.mercadopago.model.PayerCost
import com.cranaya.domain.mercadopago.model.PaymentBody
import com.cranaya.domain.mercadopago.model.PaymentResponse
import com.cranaya.domain.mercadopago.usecase.MercadoPagoUseCase
import com.cranaya.domain.order.model.Order
import com.cranaya.domain.shared.Resource
import com.cranaya.domain.shoppingBag.model.ShoppingBag
import com.cranaya.domain.shoppingBag.usecase.GetTotalUseCase
import com.cranaya.domain.shoppingBag.usecase.ShoppingBagUseCase
import com.cranaya.domain.user.model.User
import com.cranaya.inc.navigation.screen.client.ShoppingBagScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientPaymentsInstallmentsViewModel @Inject constructor(
    private val mercadoPagoUseCase: MercadoPagoUseCase,
    private val shoppingBagUseCase: ShoppingBagUseCase,
    private val authUseCase: AuthUseCase,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    var data = savedStateHandle.get<String>("payment_form")
    var cardTokenBody = CardTokenBody.fromJson(data = data!!)

    var installmentsResponse by mutableStateOf<Resource<Installment>?>(null)
        private set

    var cardTokenResponse by mutableStateOf<Resource<CardTokenResponse>?>(null)
        private set

    var paymentResponse by mutableStateOf<Resource<PaymentResponse>?>(null)
        private set

    var installment by mutableStateOf<Installment?>(null)
        private set

    var totalToPay by mutableStateOf(0.0)
        private set

    var user by mutableStateOf<User?>(null)
        private set

    var shoppingBag = mutableStateListOf<ShoppingBag>()
        private set

    init {
        getTotalToPay()
        getSessionData()
        getShoppingBag()
    }

    private fun getShoppingBag() = viewModelScope.launch {
        shoppingBag.addAll(shoppingBagUseCase.findAll().first())
    }

    private fun getSessionData() = viewModelScope.launch {
        user = authUseCase.getSessionData().first().user
    }

    private fun getTotalToPay() = viewModelScope.launch {
        totalToPay = shoppingBagUseCase.getTotal()
    }

    fun getInstallments(firstSixDigits: Int, amount: Double) = viewModelScope.launch {
        installmentsResponse = Resource.Loading
        val result = mercadoPagoUseCase.getInstallments(firstSixDigits, amount).first()
        installmentsResponse = result
        installmentsResponse.run {
            when(this) {
                is Resource.Success -> {
                    installment = this.data
                } else -> {}
            }
        }
    }

    var selectedInstallment by mutableStateOf<PayerCost?>(null)

    fun createCardToken() = viewModelScope.launch {
        cardTokenResponse = Resource.Loading
        Log.d("ClientPaymentsInstallmentsViewModel", "createCardToken: $cardTokenBody")
        val result = mercadoPagoUseCase.createCardToken(cardTokenBody)
        cardTokenResponse = result
    }

    fun createPayment(token: String) = viewModelScope.launch {
        val paymentBody = PaymentBody(
            token = token,
            installments = selectedInstallment?.installments!!,
            issuerID = installment?.issuer?.id!!,
            paymentMethodID = installment?.paymentMethodID!!,
            transactionAmount = totalToPay,
            payer = Payer(
                email = user?.email ?: "",
                identification = Identification(
                    type = cardTokenBody.cardholder.identification.type,
                    number =  cardTokenBody.cardholder.identification.number
                )
            ),
            order = Order(
                idClient = user?.id ?: "",
                idAddress = user?.address?.id ?: "",
                product = shoppingBag.toList()
            )
        )
        Log.d("ClientPaymentsInstallmentsViewModel", "createPayment: $paymentBody")
        paymentResponse = Resource.Loading
        val result = mercadoPagoUseCase.createPayment(paymentBody)
        paymentResponse = result
        Log.d("ClientPaymentsInstallmentsViewModel", "createPayment: $paymentResponse")
    }

}