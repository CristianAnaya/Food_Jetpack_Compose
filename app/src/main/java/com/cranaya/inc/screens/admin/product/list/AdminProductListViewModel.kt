package com.cranaya.inc.screens.admin.product.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cranaya.domain.category.model.Category
import com.cranaya.domain.product.model.Product
import com.cranaya.domain.product.usecase.ProductUseCase
import com.cranaya.domain.shared.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminProductListViewModel @Inject constructor(
    private val productUseCase: ProductUseCase,
    private val savedStateHandle: SavedStateHandle,
): ViewModel() {

    var data = savedStateHandle.get<String>("category")
    var category = Category.fromJson(data!!)

    var productsResponse by mutableStateOf<Resource<List<Product>>?>(null)
        private set

    var productDeleteResponse by mutableStateOf<Resource<Unit>?>(null)
        private set

    init {
        getProducts()
    }

    private fun getProducts() = viewModelScope.launch {
        productsResponse = Resource.Loading
        productUseCase.findByCategory(category.id ?: "").collect {
            productsResponse = it
        }
    }

    fun deleteProduct(id: String) = viewModelScope.launch {
        productDeleteResponse = Resource.Loading
        val result = productUseCase.deleteProduct(id = id)
        productDeleteResponse = result
    }
}