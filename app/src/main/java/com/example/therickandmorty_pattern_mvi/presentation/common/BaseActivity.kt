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
    RootBaseActivity(), IViewRenderer<STATE> {

    private lateinit var viewState: STATE
    private val viewModel : ViewModel by lazy {
        viewModelProvider(
            this.defaultViewModelProviderFactory,
            classModel.kotlin
        )
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        configureKoin()
        setContentView(getLayoutId())
        initUserInterface()
        viewModel.state.observe(this) {
            viewState = it
            render(it)
        }
        initDATA()
        initEVENT()
    }

    @LayoutRes
    abstract fun getLayoutId(): Int
    abstract fun initUserInterface()
    abstract fun initDATA()
    abstract fun initEVENT()
    fun dispatchIntent(intent: INTENT) {
        viewModel.dispatchIntent(intent)
    }
}
