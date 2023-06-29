package com.cranaya.inc.screens.admin.order.list

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cranaya.domain.order.model.Order
import com.cranaya.domain.order.usecase.OrdersUseCase
import com.cranaya.domain.shared.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminOrderListViewModel @Inject constructor(private val ordersUseCase: OrdersUseCase): ViewModel() {

    var orderResponse by mutableStateOf< Resource<List<Order>>?>(null)
    var orderByClientResponse by mutableStateOf< Resource<List<Order>>?>(null)
    var orderStatusResponse by mutableStateOf< Resource<Order>?>(null)

    fun getOrders() = viewModelScope.launch {
        orderResponse = Resource.Loading
        ordersUseCase.findAllOrders().collect {
            orderResponse = it
            Log.d("AdminOrderListViewModel", "getOrders: $orderResponse")
        }
    }


    fun getOrdersByClient(idClient: String) = viewModelScope.launch {
        orderByClientResponse = Resource.Loading
        ordersUseCase.findByClientOrder(idClient).collect {
            orderByClientResponse = it
            Log.d("AdminOrderListViewModel", "getOrdersByClient: $orderByClientResponse")
        }
    }

    fun updateStatus(id: String) = viewModelScope.launch {
        orderStatusResponse = Resource.Loading
        val result = ordersUseCase.updateStatusOrder(id)
        orderStatusResponse = result
        Log.d("AdminOrderListViewModel", "updateStatus: $orderStatusResponse")

    }

}