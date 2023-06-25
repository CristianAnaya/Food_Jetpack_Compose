package com.cranaya.data.category.repository.dataSourceImpl

import com.cranaya.data.category.mapper.toCategory
import com.cranaya.data.category.mapper.toCategoryDto
import com.cranaya.data.category.repository.dataSource.CategoriesRemoteDataSource
import com.cranaya.data.category.service.CategoriesService
import com.cranaya.data.shared.httpClient.config.ResponseToRequest
import com.cranaya.domain.category.model.Category
import com.cranaya.domain.shared.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

class CategoriesRemoteDataSourceImpl(private val categoriesService: CategoriesService): CategoriesRemoteDataSource {

    override suspend fun create(category: Category, file: File): Resource<Category> {
        val categoryDto = category.toCategoryDto()
        val connection = withContext(Dispatchers.IO) {
            file.toURI().toURL().openConnection()
        }
        val mimeType = connection.contentType // "image/png | image/jpg"
        val contentType = "text/plain"
        val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
        val fileFormData = MultipartBody.Part.createFormData("file", file.name, requestFile)
        val name = categoryDto.name.toRequestBody(contentType.toMediaTypeOrNull())
        val description = categoryDto.description.toRequestBody(contentType.toMediaTypeOrNull())

        val service = categoriesService.create(fileFormData, name, description)

        return ResponseToRequest.send(service) {
            it.toCategory()
        }
    }

    override suspend fun getCategories(): Resource<List<Category>> {
        val service = categoriesService.getCategories()

        return ResponseToRequest.send(service) { categoriesDto ->
            categoriesDto.map { it.toCategory() }
        }
    }

    override suspend fun update(id: String, category: Category): Resource<Category> {
        val service = categoriesService.update(id = id, category = category.toCategoryDto())

        return ResponseToRequest.send(service) {
            it.toCategory()
        }
    }

    override suspend fun updateWithImage(
        id: String,
        category: Category,
        file: File
    ): Resource<Category> {
        val categoryDto = category.toCategoryDto()
        val connection = withContext(Dispatchers.IO) {
            file.toURI().toURL().openConnection()
        }
        val mimeType = connection.contentType // "image/png | image/jpg"
        val contentType = "text/plain"
        val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
        val fileFormData = MultipartBody.Part.createFormData("file", file.name, requestFile)
        val name = categoryDto.name.toRequestBody(contentType.toMediaTypeOrNull())
        val description = categoryDto.description.toRequestBody(contentType.toMediaTypeOrNull())

        val service = categoriesService.updateWithImage(
            file = fileFormData,
            id = id,
            name = name,
            description = description
        )

        return ResponseToRequest.send(service) {
            it.toCategory()
        }
    }

    override suspend fun delete(id: String): Resource<Unit> {
        return ResponseToRequest.send(categoriesService.delete(id))
    }
}