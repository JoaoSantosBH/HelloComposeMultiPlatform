package com.brq.kmm.features.details.presentation

import com.brq.kmm.features.details.domain.MovieDetailsModel

data class MovieDetailsUiState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val movieId: String = "",
    val movie: MovieDetailsModel = MovieDetailsModel.EMPTY,
    val isFavorite: Boolean = false,
    val errorMessage:String = "",
    val mustShowErrorDialog:Boolean = false
) {
    companion object {
        val Empty = MovieDetailsUiState()
    }
}