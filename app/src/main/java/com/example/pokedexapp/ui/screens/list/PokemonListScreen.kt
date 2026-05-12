package com.example.pokedexapp.ui.screens.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pokedexapp.data.model.Pokemon
import com.example.pokedexapp.navigation.Screen
import com.example.pokedexapp.ui.components.PokemonCard

@Composable
fun PokemonListScreen(navController: NavController) {
    val pokemons = remember { Pokemon.getDefaultList() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Pokédex", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(pokemons) { pokemon ->
                PokemonCard(pokemon = pokemon) {
                    navController.navigate(Screen.Details.createRoute(pokemon.id, pokemon.name))
                }
            }
        }
    }
}
