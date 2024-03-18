package com.example.apppokemon.retrofit
import com.example.apppokemon.retrofit.response.Pokemon
import com.example.apppokemon.retrofit.response.PokemonResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface PokemonApiService {
    @GET("pokemon")
    fun obtenerPokemones() : Call<PokemonResponse>

    /*
    @POST("pokemon")
    fun registratPokemon(@Body pokemon : Pokemon)

    @PUT("pokemon")
    fun actualizarPokemon(@Body pokemon: Pokemon)

    */

}