package com.cranaya.inc.screens.admin.product.create

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cranaya.domain.category.model.Category
import com.cranaya.domain.product.model.Product
import com.cranaya.domain.product.usecase.CreateProductUseCase
import com.cranaya.domain.product.usecase.ProductUseCase
import com.cranaya.domain.shared.Resource
import com.cranaya.inc.screens.admin.categotry.create.AdminCategoryCreateState
import com.cranaya.inc.screens.admin.product.create.mapper.toProduct
import com.cranaya.inc.util.ComposeFileProvider
import com.cranaya.inc.util.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AdminProductCreateViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val savedStateHandle: SavedStateHandle,
    private val productUseCase: ProductUseCase
): ViewModel() {

    var state by mutableStateOf(AdminProductCreateState())
        private set

    var productResponse by mutableStateOf<Resource<Product>?>(null)
        private set

    var file1: File? = null
    var file2: File? = null
    var files: List<File> = listOf()

    val resultingActivityHandler = ResultingActivityHandler()

    var data = savedStateHandle.get<String>("category")
    var category = Category.fromJson(data!!)

    init {
        state = state.copy(
            idCategory = category.id ?: ""
        )
    }

    fun pickImage(imageNumber: Int) = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("images/*")
        if (result != null) {
            if (imageNumber == 1) {
                file1 = ComposeFileProvider.createFileFromUri(context, result)
                state = state.copy(image1 = result.toString())
            } else if (imageNumber == 2) {
                file2 = ComposeFileProvider.createFileFromUri(context, result)
                state = state.copy(image2 = result.toString())
            }
        }
    }

    fun takePhoto(imageNumber: Int) = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
            if (imageNumber == 1) {
                state = state.copy(image1 = ComposeFileProvider.getPathFromBitmap(context, result))
                file1 = File(state.image1)
            } else if (imageNumber == 2) {
                state = state.copy(image2 = ComposeFileProvider.getPathFromBitmap(context, result))
                file2 = File(state.image2)
            }
        }
    }

    fun createProduct() = viewModelScope.launch {
        if (file1 != null && file2 != null) {
            files = listOf(file1!!, file2!!)
            productResponse = Resource.Loading
            val result = productUseCase.createProduct(state.toProduct(), files)
            productResponse = result
        }
    }

    fun clearForm() {
        state = state.copy(
            name = "",
            description = "",
            image1 = "",
            image2 = "",
            price = 0.0
        )

        productResponse = null
    }

    fun onNameInput(input: String) {
        state = state.copy(name = input)
    }

    fun onDescriptionInput(input: String) {
        state = state.copy(description = input)
    }

    fun onPriceInput(input: String) {
        state = state.copy(price = input.toDouble())
    }
}