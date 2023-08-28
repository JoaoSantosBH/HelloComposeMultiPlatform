package com.brq.kmm.features.details.presentation

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.brq.kmm.core.domain.Services
import com.brq.kmm.features.details.data.local.FavoriteMovieModel
import com.brq.kmm.features.details.data.remote.MovieDetailResponse.Companion.toDomain
import com.brq.kmm.features.details.domain.FavoriteMoviesDataSource
import com.brq.kmm.features.details.domain.MovieDetailsModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MovieDetailsScreenModel(
    private val service: Services,
    private val ds: FavoriteMoviesDataSource
    ) : ScreenModel {

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
                    is MovieDetailsEvent.SetLoadingImage -> setLoading()
                    is MovieDetailsEvent.FinishLoadingImage -> finishLoading()
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

    private fun favoriteMovie(movieId: String) {
        coroutineScope.launch {
            val movie = _uiState.value.movie
             ds.insertFavoriteMovie(
                 FavoriteMovieModel(
                 movieId = movie.id, movieName = movie.title))
            _uiState.update { it.copy(
                isFavorite = ds.checkIfIsAFavoriteMovie(movieId)) }
        }
    }

    private fun unFavoriteMovie(movieId: String) {
        coroutineScope.launch {
            ds.removeFavoriteMovie(movieId)
            _uiState.update { it.copy(isFavorite = ds.checkIfIsAFavoriteMovie(movieId)) }
        }
    }

    private fun setUiValues(mv: MovieDetailsModel) {
        coroutineScope.launch {
            _uiState.update { it.copy(movie = mv, movieId = mv.id.toString(), isLoading = false) }
            val isFavorite = ds.checkIfIsAFavoriteMovie(_uiState.value.movie.id.toString())
            if (isFavorite) _uiState.update { it.copy(isFavorite = isFavorite) }
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
            setUiValues(result.toDomain())
        }
    }

}