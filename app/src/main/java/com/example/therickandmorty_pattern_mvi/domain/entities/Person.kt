package com.example.therickandmorty_pattern_mvi.domain.entities

data class Person(
    val id: Int?,
    val name: String?,
    val species: String?,
    val status: String?,
    val gender: String?,
    val image: String?
)
fun Person.toModel() = Person(id, name, species, status, gender, image)
fun List<Person>.toModel() = map { it.toModel() }
