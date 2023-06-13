package com.cranaya.data.shared.httpClient.config

import com.cranaya.data.auth.mapper.toUser
import com.cranaya.data.auth.mapper.toUserDto
import com.cranaya.data.shared.httpClient.model.ErrorResponse
import com.cranaya.domain.shared.Resource
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.lang.Exception

object ResponseToRequest {

    inline fun <T, R> send(result: Response<T>, mapper: (T) -> R): Resource<R> {
        return try {
            if (result.isSuccessful) {
                Resource.Success(mapper(result.body()!!))
            } else {
                val errorResponse: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
                Resource.Failure(errorResponse?.message ?: "Error desconocido")
            }
        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.Failure("Ocurrió un error al realizar la solicitud")
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.Failure("Verifica tu conexión a internet")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Ocurrió un error desconocido")
        }
    }

}