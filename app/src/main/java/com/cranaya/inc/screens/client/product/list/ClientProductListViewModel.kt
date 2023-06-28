package com.cranaya.inc.screens.client.product.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cranaya.domain.product.model.Product
import com.cranaya.domain.product.usecase.ProductUseCase
import com.cranaya.domain.shared.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientProductListViewModel @Inject constructor(private val productUseCase: ProductUseCase): ViewModel() {

    var productsResponse by mutableStateOf<Resource<List<Product>>?>(null)
        private set

    init {
        getProducts()
    }

    private fun getProducts() = viewModelScope.launch {
        productsResponse = Resource.Loading
        productUseCase.findAll().collect {
            productsResponse = it
        }
    }

}