package com.cranaya.inc.screens.admin.categotry.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cranaya.domain.category.model.Category
import com.cranaya.domain.category.usecase.CategoryUseCase
import com.cranaya.domain.shared.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminCategoryListViewModel @Inject constructor(private val categoryUseCase: CategoryUseCase): ViewModel() {

    var categoriesResponse by mutableStateOf<Resource<List<Category>>?>(null)

    init {
        getCategories()
    }

    private fun getCategories() = viewModelScope.launch {
        categoriesResponse = Resource.Loading
        categoryUseCase.getCategory().collect { data ->
            categoriesResponse = data
        }
    }

}