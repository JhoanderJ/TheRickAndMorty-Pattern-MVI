package com.example.therickandmorty_pattern_mvi.presentation.common

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<INTENT : ViewIntent, ACTION : ViewAction, STATE : ViewState> :
    ViewModel(), IModel<STATE, INTENT> {
}