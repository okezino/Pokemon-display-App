package com.example.custombutton.api


import com.example.custombutton.model.PokemonPojo
import com.example.custombutton.model.PokemonProfile
import com.example.custombutton.model.dataPokemon.PokemonData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    // this end point is use to get the First 20 Items of the Pokemon List
    @GET("pokemon")
    suspend fun getAllPokemon() : PokemonPojo

    /**
     * @param userId
     * with the userId as the parameter, this endpoint helps to get a class of one particular Pokemon with the userId
     */
    @GET("pokemon/{userId}")
    suspend fun getPokemonData(
            @Path("userId") userId : String
    ) : PokemonData

    /**
     * @param limit
     * @param offset
     *
     * This parameters are use to get a Range of pokemon list by changing the limit and the Offset
     */

    @GET("pokemon")
    suspend fun getNextPage(
            @Query("limit") limit : Int,
            @Query("offset") offset : Int
    ) : PokemonPojo

}