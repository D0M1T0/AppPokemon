package com.example.apppokemon

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apppokemon.databinding.ActivityMainBinding
import com.example.apppokemon.retrofit.PokemonApiService
import com.example.apppokemon.retrofit.response.PokemonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var apiRetrofit : Retrofit
    private lateinit var pokemonAdapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        apiRetrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        pokemonAdapter = PokemonAdapter()
        binding.rvpokemon.layoutManager = GridLayoutManager(applicationContext, 2)
        binding.rvpokemon.adapter = pokemonAdapter
        obtenerPokemonRetrofit()
    }

    private fun obtenerPokemonRetrofit() {
        var service = apiRetrofit.create(PokemonApiService::class.java)
        var pokemonResponse = service.obtenerPokemones()
        pokemonResponse.enqueue(object : Callback<PokemonResponse>{
            override fun onResponse(
                call: Call<PokemonResponse>,
                response: Response<PokemonResponse>
            ) {
                pokemonAdapter.agregarPokemones(response.body()!!.results)
            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })


    }
}
