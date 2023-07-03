package com.cranaya.inc.screens.admin.order.detail

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cranaya.domain.order.model.Order
import com.cranaya.domain.order.usecase.OrdersUseCase
import com.cranaya.domain.shared.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminOrderDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val ordersUseCase: OrdersUseCase
): ViewModel() {

    var data = savedStateHandle.get<String>("order")
    var order = Order.fromJson(data!!)
    var totalToPay by mutableStateOf(0.0)

    var orderStatusResponse by mutableStateOf< Resource<Order>?>(null)

    init {
        getTotal()
    }

    private fun getTotal() {
        order.orderHasProducts?.forEach {
            totalToPay += (it.quantity * it.product.price)
        }
    }

    fun updateStatus(id: String) = viewModelScope.launch {
        orderStatusResponse = Resource.Loading
        val result = ordersUseCase.updateStatusOrder(id)
        orderStatusResponse = result
        Log.d("AdminOrderListViewModel", "updateStatus: $orderStatusResponse")
    }
}