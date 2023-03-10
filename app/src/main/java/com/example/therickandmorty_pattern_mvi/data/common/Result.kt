package com.example.therickandmorty_pattern_mvi.data.common

sealed class Result<out T : Any> {
    data class SuccessResponse<T : Any>(val data: T) : Result<T>()
    data class ErrorResponse(val exception: ManageErrors) : Result<Nothing>()
    object Loading : Result<Nothing>()
}