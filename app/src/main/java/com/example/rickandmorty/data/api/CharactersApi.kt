package com.example.rickandmorty.data.api

import com.example.rickandmorty.models.CharactersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersApi {

    @GET("/character")
    suspend fun getCharactersList(
        @Query("page")
        pageNumber: Int = 1
    ) : Response<CharactersResponse>
}