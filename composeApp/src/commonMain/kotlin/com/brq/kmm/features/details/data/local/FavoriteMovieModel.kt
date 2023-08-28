package com.brq.kmm.features.details.data.local

import kotlinx.serialization.Serializable

@Serializable
data class FavoriteMovieModel(
    val movieName: String = "",
    val movieId: Int = 0
)