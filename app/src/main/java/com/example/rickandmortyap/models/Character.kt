package com.example.rickandmortyap.models

data class Character(
    val id: Int,
    val name: String,
    val species: String,
    val status: String,
    val gender: String,
    val image: String,
    val location: Location
)

data class Location(
    val name: String
)