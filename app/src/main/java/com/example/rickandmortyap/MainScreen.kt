package com.example.rickandmortyap

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortyap.ui.scripts.CharacterDetailScreen
import com.example.rickandmortyap.ui.scripts.CharacterListScreen
import com.example.rickandmortyap.utils.RetrofitInstance

import androidx.compose.foundation.layout.padding

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortyap.ui.scripts.CharacterDetailScreen
import com.example.rickandmortyap.ui.scripts.CharacterListScreen

@Composable
fun MainScreen(innerPadding: PaddingValues) { // Asegúrate de que innerPadding es de tipo PaddingValues
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "character_list",
        modifier = Modifier.padding(innerPadding) // Aplica el innerPadding aquí
    ) {
        composable("character_list") {
            CharacterListScreen(onCharacterClick = { characterId ->
                navController.navigate("character_detail/$characterId")
            })
        }
        composable("character_detail/{characterId}") { backStackEntry ->
            val characterId = backStackEntry.arguments?.getString("characterId")?.toIntOrNull()
            characterId?.let {
                CharacterDetailScreen(characterId = it) // Pasa el ID del personaje a CharacterDetailScreen
            }
        }
    }
}
