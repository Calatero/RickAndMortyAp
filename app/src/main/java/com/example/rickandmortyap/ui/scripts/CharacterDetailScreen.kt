package com.example.rickandmortyap.ui.scripts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.rickandmortyap.models.Character
import com.example.rickandmortyap.utils.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun CharacterDetailScreen(characterId: Int) {
    val characterState = remember { mutableStateOf<Character?>(null) }

    LaunchedEffect(characterId) {
        val character = withContext(Dispatchers.IO) {
            RetrofitInstance.api.getCharacterById(characterId)
        }
        characterState.value = character
    }

    characterState.value?.let { character ->
        // Renderizar los detalles del personaje en la UI
    }
}
