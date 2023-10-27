package com.example.rickandmorty.models

data class CharactersResponse(
    val info: Info,
    val characters: List<Character>
)