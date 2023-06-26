package com.cranaya.data.product.repository.dataSourceImpl

import android.util.Log
import com.cranaya.data.product.mapper.toProduct
import com.cranaya.data.product.mapper.toProductDto
import com.cranaya.data.product.repository.dataSource.ProductsRemoteDataSource
import com.cranaya.data.product.httpclient.service.ProductsService
import com.cranaya.data.shared.httpClient.config.ResponseToRequest
import com.cranaya.domain.product.model.Product
import com.cranaya.domain.shared.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

class ProductsRemoteDataSourceImpl constructor(private val productsService: ProductsService): ProductsRemoteDataSource {

    override suspend fun findAll(): Resource<List<Product>> {
        TODO("Not yet implemented")
    }

    override suspend fun findByCategory(idCategory: String): Resource<List<Product>> {
        val service = productsService.findByCategory(idCategory)

        return ResponseToRequest.send(service) { productsDto ->
            productsDto.map { it.toProduct() }
        }
    }

    override suspend fun create(product: Product, files: List<File>): Resource<Product> {

        val images = arrayOfNulls<MultipartBody.Part>(files.size)
        val contentType = "text/plain"

        files.forEachIndexed { index, file ->
            val connection = withContext(Dispatchers.IO) {
                file.toURI().toURL().openConnection()
            }
            val mimeType = connection.contentType // "image/png | image/jpg"
            val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
            images[index] = MultipartBody.Part.createFormData("files[]", file.name, requestFile)
        }

        val productDto = product.toProductDto()

        val name = productDto.name.toRequestBody(contentType.toMediaTypeOrNull())
        val description = productDto.description.toRequestBody(contentType.toMediaTypeOrNull())
        val idCategory = productDto.idCategory.toRequestBody(contentType.toMediaTypeOrNull())
        val price = productDto.price.toString().toRequestBody(contentType.toMediaTypeOrNull())

        val service = productsService.create(images, name, description, idCategory, price)

        return ResponseToRequest.send(service) {
            it.toProduct()
        }
    }

    override suspend fun updateWithImage(
        id: String,
        product: Product,
        files: List<File>?
    ): Resource<Product> {
        val productDto = product.toProductDto()

        val images = arrayOfNulls<MultipartBody.Part>(files?.size ?: 0)
        val contentType = "text/plain"
        val imagesToUpdate = arrayOfNulls<RequestBody>(productDto.imagesToUpdate?.size ?: 0)

        productDto.imagesToUpdate?.forEachIndexed { index, position ->
            imagesToUpdate[index] = position.toString().toRequestBody(contentType.toMediaTypeOrNull())
        }

        files?.forEachIndexed { index, file ->
            val connection = withContext(Dispatchers.IO) {
                file.toURI().toURL().openConnection()
            }
            val mimeType = connection.contentType // "image/png | image/jpg"
            val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
            images[index] = MultipartBody.Part.createFormData("files[]", file.name, requestFile)
        }


        val name = productDto.name.toRequestBody(contentType.toMediaTypeOrNull())
        val description = productDto.description.toRequestBody(contentType.toMediaTypeOrNull())
        val idCategory = productDto.idCategory.toRequestBody(contentType.toMediaTypeOrNull())
        val price = productDto.price.toString().toRequestBody(contentType.toMediaTypeOrNull())

        val service = productsService.updateWithImage(images, id, name, description, idCategory, price, imagesToUpdate)

        return ResponseToRequest.send(service) {
            it.toProduct()
        }
    }

    override suspend fun update(id: String, product: Product): Resource<Product> {
        val service = productsService.update(id, product.toProductDto())
        Log.d("ProductsRemoteDataSourceImpl", "update: $service")
        return ResponseToRequest.send(service) {
            it.toProduct()
        }
    }

    override suspend fun delete(id: String): Resource<Unit> {
        val service = productsService.delete(id)
        return ResponseToRequest.send(service)
    }

}