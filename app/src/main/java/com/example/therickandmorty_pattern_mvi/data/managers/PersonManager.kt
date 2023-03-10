package com.example.therickandmorty_pattern_mvi.data.managers

import com.example.therickandmorty_pattern_mvi.domain.entities.Person
import com.example.therickandmorty_pattern_mvi.data.common.Result
import kotlinx.coroutines.flow.Flow

interface PersonManager {
    fun getAllPerson(): Flow<Result<List<Person>>>
}