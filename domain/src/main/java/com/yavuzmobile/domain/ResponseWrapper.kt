package com.yavuzmobile.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException


suspend fun <T> responseWrapper(service: suspend () -> Response<T>): Flow<Result<T>> = flow {
    try {
        emit(Result.Loading())
        val response = service()
        if (response.isSuccessful) {
            response.body()?.let {
                emit(Result.Success(it))
            } ?: kotlin.run {
                emit(Result.Error(YError.Generic))
            }
        } else {
            val errorString = response.errorBody()?.string()
            try {
                val responseError = GsonProvider.get().fromJson(errorString, ResponseError::class.java)
                if (!responseError?.errorMessage.isNullOrEmpty()) {
                    emit(Result.Error(YError.Business(responseError.errorMessage.toString())))
                } else {
                    emit(Result.Error(YError.Generic))
                }
            } catch (e: Exception) {
                emit(Result.Error(YError.Generic))
            }
        }
    } catch (e: Exception) {
        when (e) {
            is UnknownHostException -> emit(Result.Error(YError.Network))
            is TimeoutException -> emit(Result.Error(YError.Timeout))
            else -> emit(Result.Error(YError.Network))
        }
    }
}