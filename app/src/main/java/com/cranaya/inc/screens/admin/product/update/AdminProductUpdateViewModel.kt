package com.cranaya.inc.screens.admin.product.update

import android.content.Context
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
import com.cranaya.inc.screens.admin.product.update.mapper.toProduct
import com.cranaya.inc.util.ComposeFileProvider
import com.cranaya.inc.util.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AdminProductUpdateViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val savedStateHandle: SavedStateHandle,
    private val productUseCase: ProductUseCase
): ViewModel() {

    var state by mutableStateOf(AdminProductUpdateState())
        private set

    var productResponse by mutableStateOf<Resource<Product>?>(null)
        private set

    private var file1: File? = null
    private var file2: File? = null
    private var files: MutableList<File> = mutableListOf()

    val resultingActivityHandler = ResultingActivityHandler()

    private var data = savedStateHandle.get<String>("product")
    private var product = Product.fromJson(data!!)

    init {
        state = state.copy(
            name = product.name,
            description = product.description,
            price = product.price,
            idCategory = product.idCategory,
            image1 =  product.image1 ?: "",
            image2 = product.image2 ?: ""
        )
    }

    fun pickImage(imageNumber: Int) = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("images/*")
        if (result != null) {
            if (imageNumber == 1) {
                file1 = ComposeFileProvider.createFileFromUri(context, result)
                state = state.copy(image1 = result.toString())
                files.add(file1!!)
            } else if (imageNumber == 2) {
                file2 = ComposeFileProvider.createFileFromUri(context, result)
                state = state.copy(image2 = result.toString())
                files.add(file2!!)
            }
        }
    }

    fun takePhoto(imageNumber: Int) = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
            if (imageNumber == 1) {
                state = state.copy(image1 = ComposeFileProvider.getPathFromBitmap(context, result))
                file1 = File(state.image1)
                files.add(file1!!)
            } else if (imageNumber == 2) {
                state = state.copy(image2 = ComposeFileProvider.getPathFromBitmap(context, result))
                file2 = File(state.image2)
                files.add(file2!!)
            }
        }
    }

    fun updateProduct() = viewModelScope.launch {
        if (file1 == null && file2 == null) {
            productResponse = Resource.Loading
            val result = productUseCase.updateProduct(product.id ?: "", state.toProduct())
            productResponse = result
        } else {
            if (file1 != null) {
                files.add(file1!!)
                state.imagesToUpdate.add(0)
            }
            if (file2 != null) {
                files.add(file2!!)
                state.imagesToUpdate.add(1)
            }

            val result = productUseCase.updateProductWithImage(product.id ?: "", state.toProduct(), files.toList())
            productResponse = result
        }

        files.clear()
        file1 = null
        file2 = null
        state.imagesToUpdate.clear()
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