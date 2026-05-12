package com.example.pokedexapp.data.model

data class Pokemon(
    val id: String,
    val name: String
) {
    val spriteUrl: String
        get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"

    val artworkUrl: String
        get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"

    companion object {
        fun getDefaultList(): List<Pokemon> = listOf(
            Pokemon("1",  "Bulbasaur"),
            Pokemon("2",  "Ivysaur"),
            Pokemon("3",  "Venusaur"),
            Pokemon("4",  "Charmander"),
            Pokemon("5",  "Charmeleon"),
            Pokemon("6",  "Charizard"),
            Pokemon("7",  "Squirtle"),
            Pokemon("25", "Pikachu")
        )
    }
}
