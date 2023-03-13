package com.example.therickandmorty_pattern_mvi.presentation.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class BaseViewModel<INTENT : ViewIntent, ACTION : ViewAction, STATE : ViewState> :
    ViewModel() , IModel<STATE,INTENT> {

        private val mState = MutableLiveData<STATE>()
    override val state : LiveData<STATE>
        get() {
            return mState
        }
    fun buildUI(block : suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch { block() }
    }


}