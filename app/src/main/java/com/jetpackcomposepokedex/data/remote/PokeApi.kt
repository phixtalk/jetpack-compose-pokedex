package com.jetpackcomposepokedex.data.remote

import com.jetpackcomposepokedex.data.remote.responses.Pokemon
import com.jetpackcomposepokedex.data.remote.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    @GET("pokenmon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ) : PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokenmonInfo(
        @Path("name") name: String
    ): Pokemon
}