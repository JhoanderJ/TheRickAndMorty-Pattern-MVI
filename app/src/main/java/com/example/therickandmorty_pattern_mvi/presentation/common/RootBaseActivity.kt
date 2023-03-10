package com.example.therickandmorty_pattern_mvi.presentation.common

import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class RootBaseActivity : AppCompatActivity() {

    public fun configureKoin() {
        startKoin {
            androidContext(this@RootBaseActivity)
            modules()
        }
    }
}