package com.cranaya.inc.screens.admin.product.create

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cranaya.domain.category.model.Category
import com.cranaya.domain.shared.Resource
import com.cranaya.inc.screens.admin.categotry.create.AdminCategoryCreateState
import com.cranaya.inc.util.ComposeFileProvider
import com.cranaya.inc.util.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AdminProductCreateViewModel @Inject constructor(
    @ApplicationContext private val context: Context
): ViewModel() {

    var state by mutableStateOf(AdminProductCreateState())
        private set

    var categoryResponse by mutableStateOf<Resource<Category>?>(null)

    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()


    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("images/*")
        if (result != null) {
            file = ComposeFileProvider.createFileFromUri(context, result)
//            state = state.copy(image = result.toString())
        }
    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
//            state = state.copy(image = ComposeFileProvider.getPathFromBitmap(context, result))
//            file = state.image?.let { File(it) }
        }
    }

    fun clearForm() {
        state = state.copy(
            name = "",
            description = "",
//            image = ""
        )

        categoryResponse = null
    }

    fun onNameInput(input: String) {
        state = state.copy(name = input)
    }

    fun onDescriptionInput(input: String) {
        state = state.copy(description = input)
    }
}