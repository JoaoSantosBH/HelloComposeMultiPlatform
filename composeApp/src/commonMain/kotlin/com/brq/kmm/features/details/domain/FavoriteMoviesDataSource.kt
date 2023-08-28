package com.brq.kmm.features.details.domain

import com.brq.kmm.features.details.data.local.FavoriteMovieModel


interface FavoriteMoviesDataSource {

    fun getFavoriteMovie(movieId:String) : FavoriteMovieModel
    fun insertFavoriteMovie(movie:FavoriteMovieModel) : Unit
    fun removeFavoriteMovie(movieId:String) : Unit
    fun checkIfIsAFavoriteMovie(movieId: String) : Boolean
    fun getFavoriteMoviesList() : List<Int>

}