package com.brq.kmm.features.details.presentation

sealed class MovieDetailsEvent {
    
    object IsLoading: MovieDetailsEvent()
    object GetMovieDetails: MovieDetailsEvent()
    object SetLoadingImage: MovieDetailsEvent()
    object FinishLoadingImage: MovieDetailsEvent()
    data class FavoriteMovie(val id: Int) : MovieDetailsEvent()
    data class UnFavoriteMovie(val id: Int) : MovieDetailsEvent()
    data class Error(val message: String) : MovieDetailsEvent()

}