package com.cranaya.inc.screens.admin.categotry.update

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cranaya.domain.category.model.Category
import com.cranaya.domain.category.usecase.CategoryUseCase
import com.cranaya.domain.shared.Resource
import com.cranaya.inc.screens.admin.categotry.create.mapper.toCategory
import com.cranaya.inc.screens.admin.categotry.update.mapper.toCategory
import com.cranaya.inc.util.ComposeFileProvider
import com.cranaya.inc.util.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AdminCategoryUpdateViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val categoryUseCase: CategoryUseCase,
    @ApplicationContext private val context: Context
): ViewModel() {

    var state by mutableStateOf(AdminCategoryUpdateState())
        private set

    var categoryResponse by mutableStateOf<Resource<Category>?>(null)

    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    var data = savedStateHandle.get<String>("category")
    var category = Category.fromJson(data!!)

    init {
        state = state.copy(
            name = category.name,
            image = category.image!!,
            description = category.description
        )
    }

    fun onUpdate() {
        if (file != null) {
            updateCategoryWithImage()
        } else {
            updateCategory()
        }
    }

    private fun updateCategory() = viewModelScope.launch {
        categoryResponse = Resource.Loading
        val result = categoryUseCase.updateCategory(category.id!!, state.toCategory())
        categoryResponse = result
    }

    private fun updateCategoryWithImage() = viewModelScope.launch {
        if (file != null) {
            categoryResponse = Resource.Loading
            val result = categoryUseCase.updateCategoryWithImage(category.id!!, state.toCategory(), file!!)
            categoryResponse = result
        }
    }

    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("images/*")
        if (result != null) {
            file = ComposeFileProvider.createFileFromUri(context, result)
            state = state.copy(image = result.toString())
        }
    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
            state = state.copy(image = ComposeFileProvider.getPathFromBitmap(context, result))
            file = File(state.image)
        }
    }

    fun onNameInput(input: String) {
        state = state.copy(name = input)
    }

    fun onDescriptionInput(input: String) {
        state = state.copy(description = input)
    }
}