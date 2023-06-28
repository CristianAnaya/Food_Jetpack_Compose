package com.cranaya.inc.screens.client.product.detail

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cranaya.domain.product.model.Product
import com.cranaya.domain.shoppingBag.model.ShoppingBag
import com.cranaya.domain.shoppingBag.usecase.ShoppingBagUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientProductDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val shoppingBagUseCase: ShoppingBagUseCase
): ViewModel() {

    var data = savedStateHandle.get<String>("product")
    var product = Product.fromJson(data!!)
    var productImages = listOf<String>(product.image1 ?: "", product.image2 ?: "")

    var quantity by mutableStateOf(0)
        private set

    var price by mutableStateOf(0.0)
        private set

    init {
        getShoppingBag()
    }

    fun add() {
        quantity += 1
        price = product.price * quantity
    }

    fun remove() {
        if (quantity > 0) {
            quantity -= 1
            price = product.price * quantity
        }
    }

    private fun getShoppingBag() = viewModelScope.launch {
        shoppingBagUseCase.findById(product.id ?: "")?.let {
            quantity = it.quantity
            price = it.price * quantity
        }
    }

    fun saveItem() = viewModelScope.launch {
        if (quantity > 0) {
            val shoppingBag = ShoppingBag(
                id = product.id ?: "",
                name = product.name,
                price = product.price,
                image1 = product.image1 ?: "",
                idCategory = product.idCategory,
                quantity = quantity
            )
            Log.d("ClientProductDetailViewModel", "saveItem: DATA: $shoppingBag ")
            shoppingBagUseCase.add(shoppingBag)
        }
    }
}