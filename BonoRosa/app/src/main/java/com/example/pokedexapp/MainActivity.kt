package com.example.pokedexapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokedexapp.navigation.Screen
import com.example.pokedexapp.ui.screens.about.AboutScreen
import com.example.pokedexapp.ui.screens.detail.PokemonDetailScreen
import com.example.pokedexapp.ui.screens.list.PokemonListScreen
import com.example.pokedexapp.ui.theme.PokedexAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexAppTheme {
                MainContainer()
            }
        }
    }
}

@Composable
fun MainContainer() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Lista") },
                    label = { Text("Lista") },
                    selected = false,
                    onClick = { navController.navigate(Screen.Home.route) }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Info, contentDescription = "Sobre") },
                    label = { Text("Sobre") },
                    selected = false,
                    onClick = { navController.navigate(Screen.About.route) }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                PokemonListScreen(navController)
            }
            composable(
                route = Screen.Details.route,
                arguments = listOf(
                    navArgument("pokemonId") { type = NavType.StringType },
                    navArgument("pokemonName") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getString("pokemonId") ?: "1"
                val name = backStackEntry.arguments?.getString("pokemonName") ?: "Bulbasaur"
                PokemonDetailScreen(id = id, name = name, navController = navController)
            }
            composable(Screen.About.route) {
                AboutScreen(navController)
            }
        }
    }
}
