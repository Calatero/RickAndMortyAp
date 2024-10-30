package com.example.rickandmortyap.services

import com.example.rickandmortyap.models.Character
import com.example.rickandmortyap.models.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApiService {
    @GET("character/")
    suspend fun getCharacters(): CharacterResponse // Si ya tienes una respuesta con todos los personajes

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Character
}