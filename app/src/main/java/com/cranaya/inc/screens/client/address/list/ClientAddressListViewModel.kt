package com.cranaya.inc.screens.client.address.list

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cranaya.domain.address.model.Address
import com.cranaya.domain.address.usecase.AddressUseCase
import com.cranaya.domain.auth.usecase.AuthUseCase
import com.cranaya.domain.shared.Resource
import com.cranaya.domain.user.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientAddressListViewModel @Inject constructor(
    private val addressUseCase: AddressUseCase,
    private val authUseCase: AuthUseCase
): ViewModel() {

    var addressResponse by mutableStateOf<Resource<List<Address>>?>(null)
        private set

    var selectedAddress by mutableStateOf("")
        private set

    var user: User? = null

    fun getSessionData() = viewModelScope.launch {
        user = authUseCase.getSessionData().first().user
        getAddress(user?.id ?: "")

        if (user?.address != null) {
            selectedAddress = user?.address?.id ?: ""
        }
    }

    private fun getAddress(idUser: String) = viewModelScope.launch {
        addressResponse = Resource.Loading
        addressUseCase.findByUserAddress(idUser).collect {
            Log.d("ClientAddressListViewModel", "getAddress: $it")
            addressResponse = it
        }
    }

    fun onSelectedAddressInput(address: Address) = viewModelScope.launch {
        selectedAddress = address.id ?: ""
        user?.address = address
        user?.let { authUseCase.updateSession(it) }
    }

}