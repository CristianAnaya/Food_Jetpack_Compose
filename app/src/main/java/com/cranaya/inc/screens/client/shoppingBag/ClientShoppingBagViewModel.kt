package com.cranaya.inc.screens.client.shoppingBag

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cranaya.domain.shoppingBag.model.ShoppingBag
import com.cranaya.domain.shoppingBag.usecase.ShoppingBagUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientShoppingBagViewModel @Inject constructor(
    private val shoppingBagUseCase: ShoppingBagUseCase
): ViewModel() {

    var shoppingBags = mutableStateListOf<ShoppingBag>()
        private set

    var total by mutableStateOf(0.0)
        private set

//    init {
//        getShoppingBag()
//    }

    private fun getTotal() {
        total = 0.0
        shoppingBags.forEach {
            total += (it.price * it.quantity)
        }
    }

    fun getShoppingBag() = viewModelScope.launch {
        shoppingBagUseCase.findAll().collect {
            shoppingBags.clear()
            shoppingBags.addAll(it)
            getTotal()
        }
    }

    fun addItem(shoppingBag: ShoppingBag) = viewModelScope.launch {
        shoppingBag.quantity = shoppingBag.quantity + 1
        shoppingBagUseCase.add(shoppingBag)
        getTotal()
    }

    fun subtractItem(shoppingBag: ShoppingBag) = viewModelScope.launch {
        if (shoppingBag.quantity > 1) {
            shoppingBag.quantity = shoppingBag.quantity - 1
            shoppingBagUseCase.add(shoppingBag)
            getTotal()
        }
    }

    fun deleteItem(id: String) = viewModelScope.launch {
        shoppingBagUseCase.delete(id)
        getTotal()
    }
}