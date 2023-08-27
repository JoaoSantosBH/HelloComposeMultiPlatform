package com.brq.kmm.features.details.presentation

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.brq.kmm.core.domain.Services
import com.brq.kmm.features.details.data.remote.MovieDetailResponse.Companion.toDomain
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MovieDetailsScreenModel(private val service: Services) : ScreenModel {

    private val _uiState: MutableStateFlow<MovieDetailsUiState> =
        MutableStateFlow(MovieDetailsUiState.Empty)
    val uiState: StateFlow<MovieDetailsUiState> = _uiState.asStateFlow()
    private val pendingActions = MutableSharedFlow<MovieDetailsEvent>()

    init {
        handleEvents()
    }

    fun onEvent(event: MovieDetailsEvent) {
        coroutineScope.launch {
            pendingActions.emit(event)
        }
    }

    private fun handleEvents() {
        coroutineScope.launch {
            pendingActions.collect { event ->
                when (event) {
                    MovieDetailsEvent.SetLoadingImage -> setLoading()
                    MovieDetailsEvent.FinishLoadingImage -> finishLoading()
                    is MovieDetailsEvent.FavoriteMovie -> favoriteMovie(event.id)
                    is MovieDetailsEvent.UnFavoriteMovie -> unFavoriteMovie(event.id)
                    is MovieDetailsEvent.Error -> showErrorMessage(event.message)
                    else -> {}
                }

            }
        }
    }

    private fun showErrorMessage(message: String) {
        _uiState.update {
            it.copy(
                isLoading = false,
                errorMessage = message,
                mustShowErrorDialog = true
            )
        }

    }

    private fun favoriteMovie(movieId: Int) {
        coroutineScope.launch {
//            db.insertFavoriteMovie(movieId.toLocal())
//            _uiState.update { it.copy(
//                isFavorite = db.checkIfisAFavoriteMovie(movieId)) }
        }
    }

    private fun unFavoriteMovie(id: Int) {
        coroutineScope.launch {
//            val toRemove = db.getFavoriteMovieById(id)
//            db.removeFavoriteMovie(toRemove)
//            _uiState.update { it.copy(isFavorite = db.checkIfisAFavoriteMovie(id)) }
        }
    }

    private fun finishLoading() {
        _uiState.update { it.copy(isLoading = false) }
    }

    private fun setLoading() {
        _uiState.update { it.copy(isLoading = true) }
    }

    fun getMoviesDetail(movieId: Int) {
        coroutineScope.launch {
            setLoading()
            val result = service.getMovieDetails(movieId)
            _uiState.update { it.copy(movie = result.toDomain(), isLoading = false) }
        }
    }

    private fun setMovieId(movieId: String) {
        _uiState.update { it.copy(movieId = movieId) }
    }
}