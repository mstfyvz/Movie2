package com.yavuzmobile.domain

sealed class Result<out R> {
    data class Loading<out T>(val data: T? = null): Result<T>()
    data class Success<out T>(val data: T) : Result<T>()
    data class Error<out T>(val error: YError, val data: T?  = null) : Result<T>()
}