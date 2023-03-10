package com.example.therickandmorty_pattern_mvi.presentation.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.therickandmorty_pattern_mvi.R
import com.example.therickandmorty_pattern_mvi.data.common.ManageErrors
import kotlin.reflect.KClass

/**
 * Created by Rim Gazzah on 8/31/20.
 **/
fun <T : ViewModel> RootBaseActivity.viewModelProvider(
    factory: ViewModelProvider.Factory,
    model: KClass<T>
): T {
    return ViewModelProvider(this, factory).get(model.java)
}

fun Boolean.runIfTrue(block: () -> Unit) {
    if (this) {
        block()
    }
}

fun ManageErrors.getMessage(context: Context): String {
    return when (this) {
        is ManageErrors.ErrorData -> context.getString(R.string.error_empty_data)
        is ManageErrors.ErrorServer -> context.getString(R.string.error_server_error)
        is ManageErrors.ErrorException ->  context.getString(
            R.string.error_exception
        )
    }

}