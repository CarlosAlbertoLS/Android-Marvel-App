package com.sonder.marvelapplication.characters.data.network.response

data class Stories(
    val available: String,
    val collectionURI: String,
    val items: List<ItemXXX>,
    val returned: String
)