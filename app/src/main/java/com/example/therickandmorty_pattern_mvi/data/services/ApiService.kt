package com.example.therickandmorty_pattern_mvi.data.services

import com.example.therickandmorty_pattern_mvi.domain.entities.Cartoon
import retrofit2.Response
import retrofit2.http.GET

const val PATH_CHARACTER = "character"

interface ApiService {
    @GET(PATH_CHARACTER)
    suspend fun getAllPersons(): Response<Cartoon>
}