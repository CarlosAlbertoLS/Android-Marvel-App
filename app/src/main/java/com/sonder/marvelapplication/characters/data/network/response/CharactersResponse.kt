package com.sonder.marvelapplication.characters.data.network.response

data class CharactersResponse(
    val attributionHTML: String,
    val attributionText: String,
    val code: String,
    val copyright: String,
    val data: Data,
    val status: String
)