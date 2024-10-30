package com.example.rickandmortyap.ui.scripts


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.rickandmortyap.models.Character
import com.example.rickandmortyap.utils.RetrofitInstance
import kotlinx.coroutines.launch

@Composable
fun CharacterListScreen(onCharacterClick: (Int) -> Unit) {
    var characters by remember { mutableStateOf(listOf<Character>()) }

    LaunchedEffect(Unit) {
        characters = RetrofitInstance.api.getCharacters().results
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(characters.size) { index ->
            CharacterItem(character = characters[index], onClick = { onCharacterClick(characters[index].id) })
        }
    }
}

@Composable
fun CharacterItem(character: Character, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(Color.LightGray)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberAsyncImagePainter(character.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = character.name, color = Color.Black)
                Text(text = character.species, color = Color.Gray)
            }
        }
    }
}
