package com.example.therickandmorty_pattern_mvi.presentation.common

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import org.koin.core.context.startKoin

abstract class BaseActivity<
        INTENT : ViewIntent,
        ACTION : ViewAction,
        STATE : ViewState,
        ViewModel : BaseViewModel<INTENT, ACTION, STATE>>(private val classModel: Class<ViewModel>) :
    RootBaseActivity() {

    private lateinit var viewState: STATE
    private val viewModel : ViewModel by lazy {
        viewModelProvider(
            this.defaultViewModelProviderFactory,
            classModel.kotlin
        )
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(getLayoutId())
        initUserInterface()

        // TODO OBSERVER STATE WITH VIEWMODEL

        initDATA()
        initEVENT()
    }

    @LayoutRes
    abstract fun getLayoutId(): Int
    abstract fun initUserInterface()
    abstract fun initDATA()
    abstract fun initEVENT()

    abstract fun dispatch(intent: INTENT){
        viewModel.dispatchIntent(intent)
    }
}
