package com.sonder.marvelapplication.characters.domain

import com.sonder.marvelapplication.characters.data.CharactersRepository
import com.sonder.marvelapplication.characters.data.CharactersRepositoryImp
import com.sonder.marvelapplication.characters.data.network.response.CharactersResponse
import javax.inject.Inject

class CharacterUseCase @Inject constructor(
    private val repository: CharactersRepositoryImp
) {
    suspend operator fun invoke(): CharactersResponse {
        return repository.charactersResponse()
    }
}