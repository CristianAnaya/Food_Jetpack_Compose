package com.cranaya.inc.screens.client.address.create

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cranaya.domain.address.model.Address
import com.cranaya.domain.address.usecase.AddressUseCase
import com.cranaya.domain.auth.usecase.AuthUseCase
import com.cranaya.domain.shared.Resource
import com.cranaya.inc.screens.client.address.create.mapper.toAddress
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientAddressCreateViewModel @Inject constructor(
    private val addressUseCase: AddressUseCase,
    private val authUseCase: AuthUseCase
) : ViewModel() {

    var state by mutableStateOf(ClientAddressCreateState())
        private set

    var addressResponse by mutableStateOf<Resource<Address>?>(null)

    fun getSessionData() = viewModelScope.launch {
        val user = authUseCase.getSessionData().first().user
        state = state.copy(idUser = user?.id ?: "")
    }

    fun createAddress() = viewModelScope.launch {
        addressResponse = Resource.Loading
        val result = addressUseCase.createAddress(state.toAddress())
        addressResponse = result
    }

    fun onAddressInput(address: String) {
        state = state.copy(address = address)
    }

    fun onNeighborhoodInput(neighborhood: String) {
        state = state.copy(neighborhood = neighborhood)
    }

    fun cleanForm() {
        state = state.copy(
            address = "",
            neighborhood = ""
        )
        addressResponse = null
    }
}