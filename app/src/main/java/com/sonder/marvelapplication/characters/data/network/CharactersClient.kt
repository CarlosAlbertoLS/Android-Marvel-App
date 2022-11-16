package com.sonder.marvelapplication.characters.data.network

import com.sonder.marvelapplication.characters.data.network.response.CharactersResponse
import com.sonder.marvelapplication.codeprivatekey.PrivateKey
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersClient {
    @GET("characters?ts=1&apikey=73c367abbe2e0851e72429b0dfed6e20")
    suspend fun getAllCharacters(): CharactersResponse
}