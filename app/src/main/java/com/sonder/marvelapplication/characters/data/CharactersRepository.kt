package com.sonder.marvelapplication.characters.data

import com.google.gson.JsonObject
import com.sonder.marvelapplication.characters.data.network.CharactersClient
import com.sonder.marvelapplication.characters.data.network.response.CharactersResponse
import com.sonder.marvelapplication.characters.data.network.response.Data
import javax.inject.Inject

interface CharactersRepository {
    suspend fun charactersResponse(): CharactersResponse
}

class CharactersRepositoryImp @Inject constructor(
    private val charactersClient: CharactersClient
): CharactersRepository{
    override suspend fun charactersResponse(): CharactersResponse {
        val attributionHTML = charactersClient.getAllCharacters().attributionHTML
        val attributionText = charactersClient.getAllCharacters().attributionText
        val code = charactersClient.getAllCharacters().code
        val copyright = charactersClient.getAllCharacters().copyright
        val count = charactersClient.getAllCharacters().data.count
        val result = charactersClient.getAllCharacters().data.results
        val status = charactersClient.getAllCharacters().status
        val data = Data(count, result)
        val character = CharactersResponse(attributionHTML, attributionText, code, copyright, data, status)
        return character
    }
}