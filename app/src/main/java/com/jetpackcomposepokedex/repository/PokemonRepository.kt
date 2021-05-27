package com.jetpackcomposepokedex.repository

import com.jetpackcomposepokedex.data.remote.PokeApi
import com.jetpackcomposepokedex.data.remote.responses.Pokemon
import com.jetpackcomposepokedex.data.remote.responses.PokemonList
import com.jetpackcomposepokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped //this class will live as long as our activity does
//normally we would want to create an interface here,
//and our repository will implement it. Good for testability
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokenList(limit: Int, offset: Int): Resource<PokemonList>{
        val response = try {
            api.getPokemonList(limit, offset)
        }catch (e: Exception){
            return Resource.Error("An unknown error occurred")
        }
        return Resource.Success(response)
    }

    suspend fun getPokenInfo(pokemonName: String): Resource<Pokemon>{
        val response = try {
            api.getPokenmonInfo(pokemonName)
        }catch (e: Exception){
            return Resource.Error("An unknown error occurred")
        }
        return Resource.Success(response)
    }

}