package com.example.therickandmorty_pattern_mvi.data.managers

import com.example.therickandmorty_pattern_mvi.data.common.ManageErrors
import com.example.therickandmorty_pattern_mvi.data.common.Result
import com.example.therickandmorty_pattern_mvi.data.services.ApiService
import com.example.therickandmorty_pattern_mvi.domain.entities.Person
import com.example.therickandmorty_pattern_mvi.domain.entities.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class PersonManagerImpl(private val api: ApiService) : PersonManager {
    override fun getAllPerson(): Flow<Result<List<Person>>> = flow {
        api.getAllPersons().run {
            if (isSuccessful) {
                if (body() == null) {
                    emit(Result.ErrorResponse(ManageErrors.ErrorData))
                } else {
                    emit(Result.SuccessResponse(body()!!.results.toModel()))
                }
            } else {
                emit(Result.ErrorResponse(ManageErrors.ErrorServer))
            }
        }
    }
}