package com.cranaya.inc.screens.client.order.list

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cranaya.domain.auth.usecase.AuthUseCase
import com.cranaya.domain.order.model.Order
import com.cranaya.domain.order.usecase.OrdersUseCase
import com.cranaya.domain.shared.Resource
import com.cranaya.domain.user.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientOrderListViewModel @Inject constructor(
    private val ordersUseCase: OrdersUseCase,
    private val authUseCase: AuthUseCase
): ViewModel() {

    var orderResponse by mutableStateOf< Resource<List<Order>>?>(null)
        private set

    var user by mutableStateOf<User?>(null)



    fun getSessionData() = viewModelScope.launch {
        user = authUseCase.getSessionData().first().user
        getOrdersByClient(user?.id ?: "")
    }

    private fun getOrdersByClient(id: String) = viewModelScope.launch {
        orderResponse = Resource.Loading
        ordersUseCase.findAllOrders().collect {
            orderResponse = it
            Log.d("ClientOrderListViewModel", "getOrders: $orderResponse")
        }
    }


//    fun getOrdersByClient(idClient: String) = viewModelScope.launch {
//        orderByClientResponse = Resource.Loading
//        ordersUseCase.findByClientOrder(idClient).collect {
//            orderByClientResponse = it
//            Log.d("AdminOrderListViewModel", "getOrdersByClient: $orderByClientResponse")
//        }
//    }
//

}