package com.brq.kmm.features.home.presentation

sealed class HomeEvent {

    data class OnClickCardMovieEvent(val movieId: Int?) : HomeEvent()
    object TabMoviesEvent : HomeEvent()
    object FavMoviesEvent : HomeEvent()


}