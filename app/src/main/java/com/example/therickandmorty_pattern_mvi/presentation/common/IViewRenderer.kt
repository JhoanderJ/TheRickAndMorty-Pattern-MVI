package com.example.therickandmorty_pattern_mvi.presentation.common

interface IViewRenderer<STATE> {
    fun render(state: STATE)
}