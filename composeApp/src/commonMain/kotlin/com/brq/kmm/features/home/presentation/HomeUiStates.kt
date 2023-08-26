package com.brq.kmm.features.home.presentation

import com.brq.kmm.features.home.domain.MovieModel

data class HomeUiStates(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val popularMovies: List<MovieModel> = emptyList(),
    val cachedMovies: List<MovieModel> = emptyList(),
    val favoriteIds: List<Int?> = emptyList(),
    val mustShowDialog: Boolean = false,
    val errorMessage: String = "",
    val isTabFavSelected : Boolean = false
) {
    companion object {
        val Empty = HomeUiStates()
    }

}