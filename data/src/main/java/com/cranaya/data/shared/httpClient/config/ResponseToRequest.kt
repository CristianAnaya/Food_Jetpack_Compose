package com.cranaya.data.shared.httpClient.config

import android.util.Log
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

    fun <T> send(result: Response<T>): Resource<T> {
        return try {
            if (result.isSuccessful) { // 201
                Resource.Success(result.body()!!)
            }
            else {
                val errorResponse: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
                Resource.Failure(errorResponse?.message ?: "Error desconido")
            }
        }
        catch (e: HttpException) {
            Log.d("ResponseToRequest", "Message: ${e.message()}")
            Log.d("ResponseToRequest", "Message: ${e.cause}")
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconido en la peticion Http")
        }
        catch (e: IOException) {
            Log.d("ResponseToRequest", "Message: ${e}")
            Log.d("ResponseToRequest", "Message: ${e.cause}")
            e.printStackTrace()
            Resource.Failure("Verifica tu conexion a internet")
        }
        catch (e: Exception) {
            Log.d("ResponseToRequest", "Message: ${e}")
            Log.d("ResponseToRequest", "Message: ${e.cause}")
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconido")
        }
    }


}