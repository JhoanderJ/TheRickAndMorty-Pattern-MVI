package com.example.therickandmorty_pattern_mvi.data.common

sealed class ManageErrors {
    object ErrorData : ManageErrors()
    object ErrorServer : ManageErrors()
    data class ErrorException(val throwable: Throwable) : ManageErrors()
}