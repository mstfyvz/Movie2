package com.yavuzmobile.domain

data class UiState<T>(
    val isLoading: Boolean = false,
    val movie: T? = null,
    val error: YError? = null
)