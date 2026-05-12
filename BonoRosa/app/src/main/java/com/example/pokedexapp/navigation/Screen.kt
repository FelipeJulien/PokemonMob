package com.example.pokedexapp.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Details : Screen("details/{pokemonId}/{pokemonName}") {
        fun createRoute(id: String, name: String) = "details/$id/$name"
    }
    object About : Screen("about")
}
