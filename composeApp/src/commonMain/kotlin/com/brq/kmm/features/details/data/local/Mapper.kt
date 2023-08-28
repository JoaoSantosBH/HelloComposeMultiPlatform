package com.brq.kmm.features.details.data.local

import database.FavoriteMovieEntity


fun FavoriteMovieEntity.toDomain() = FavoriteMovieModel(
    movieName = this.movieName,
    movieId = this.movieId.toInt()
)

fun FavoriteMovieModel.toLocal() : FavoriteMovieEntity{
    return FavoriteMovieEntity(
        movieName = this.movieName,
        movieId = this.movieId.toString()
    )
}

