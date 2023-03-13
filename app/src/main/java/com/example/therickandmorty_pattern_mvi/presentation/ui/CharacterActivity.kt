package com.example.therickandmorty_pattern_mvi.presentation.ui

import android.os.Bundle
import com.example.therickandmorty_pattern_mvi.R
import com.example.therickandmorty_pattern_mvi.presentation.common.BaseActivity

class CharacterActivity : BaseActivity<CharacterIntent,CharacterAction,CharacterState,CharacterViewModel>(CharacterViewModel::class.java) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun getLayoutId(): Int {
        TODO("Not yet implemented")
    }

    override fun initUserInterface() {
        TODO("Not yet implemented")
    }

    override fun initDATA() {

    }

    override fun initEVENT() {
        TODO("Not yet implemented")
    }

    override fun getIntent(intent: CharacterIntent) {
        TODO("Not yet implemented")
    }
}