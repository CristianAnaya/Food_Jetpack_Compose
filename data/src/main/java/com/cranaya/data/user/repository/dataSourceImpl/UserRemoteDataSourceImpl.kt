package com.cranaya.data.user.repository.dataSourceImpl

import com.cranaya.data.user.mapper.toUser
import com.cranaya.data.user.mapper.toUserDto
import com.cranaya.data.shared.httpClient.config.ResponseToRequest
import com.cranaya.data.user.repository.dataSource.UserRemoteDataSource
import com.cranaya.data.user.service.UserService
import com.cranaya.domain.shared.Resource
import com.cranaya.domain.user.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

class UserRemoteDataSourceImpl(private val userService: UserService): UserRemoteDataSource {

    override suspend fun update(id: String, user: User): Resource<User> {
        val userDto = user.toUserDto()
        val userResponse = userService.update(id, userDto)
        return ResponseToRequest.send(userResponse) {
            it.toUser()
        }
    }

    override suspend fun updateWithImage(id: String, user: User, file: File): Resource<User> {
        val connection = withContext(Dispatchers.IO) {
            file.toURI().toURL().openConnection()
        }
        val mimeType = connection.contentType // "image/png | image/jpg"
        val contentType = "text/plain"
        val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
        val fileFormData = MultipartBody.Part.createFormData("file", file.name, requestFile)
        val nameData = user.name.toRequestBody(contentType.toMediaTypeOrNull())
        val lastnameData = user.lastname.toRequestBody(contentType.toMediaTypeOrNull())
        val phoneData = user.phone.toRequestBody(contentType.toMediaTypeOrNull())

        val service = userService.updateWithImage(fileFormData, id, nameData, lastnameData, phoneData)

        return ResponseToRequest.send(service) {
            it.toUser()
        }
    }

}