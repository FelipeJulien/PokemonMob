package com.example.pokedexapp.ui.screens.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.pokedexapp.data.model.Pokemon

@Composable
fun PokemonDetailScreen(id: String, name: String, navController: NavController) {
    val pokemon = remember(id, name) { Pokemon(id = id, name = name) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = pokemon.name,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        AsyncImage(
            model = pokemon.artworkUrl,
            contentDescription = pokemon.name,
            modifier = Modifier.size(250.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Pokémon ID: #${pokemon.id}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("Voltar para Lista")
        }
    }
}
