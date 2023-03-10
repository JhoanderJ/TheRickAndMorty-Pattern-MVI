package com.example.therickandmorty_pattern_mvi.presentation.common

import androidx.lifecycle.LiveData

interface IModel<STATE, INTENT> {
    val state: LiveData<STATE>
    fun dispatchIntent(intent: INTENT)
}