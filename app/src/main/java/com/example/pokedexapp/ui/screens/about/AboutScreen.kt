package com.example.pokedexapp.ui.screens.about

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pokedexapp.navigation.Screen

@Composable
fun AboutScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = null,
            modifier = Modifier.size(100.dp),
            tint = Color.Red
        )
        Text(text = "Pokédex App v1.0", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(
            text = "Este app foi desenvolvido para a aula de Android usando Jetpack Compose e a PokeAPI.",
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp)
        )
        Button(onClick = { navController.navigate(Screen.Home.route) }) {
            Text("Ir para Início")
        }
    }
}
