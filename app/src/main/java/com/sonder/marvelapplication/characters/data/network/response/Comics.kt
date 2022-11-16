package com.sonder.marvelapplication.characters.data.network.response

data class Comics(
    val available: String,
    val collectionURI: String,
    val items: List<Item>,
    val returned: String
)