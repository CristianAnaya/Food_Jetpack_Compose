package com.cranaya.inc.screens.client.category.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cranaya.domain.category.model.Category
import com.cranaya.domain.category.usecase.CategoryUseCase
import com.cranaya.domain.shared.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientCategoryListViewModel @Inject constructor(private val categoryUseCase: CategoryUseCase): ViewModel() {

    var categoriesResponse by mutableStateOf<Resource<List<Category>>?>(null)
        private set

    init {
        getCategories()
    }

    private fun getCategories() = viewModelScope.launch {
        categoriesResponse = Resource.Loading
        categoryUseCase.getCategory().collect {
            categoriesResponse = it
        }
    }
}