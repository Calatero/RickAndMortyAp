package com.example.rickandmortyap.utils

import com.example.rickandmortyap.services.CharacterApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: CharacterApiService by lazy {
        retrofit.create(CharacterApiService::class.java)
    }
}