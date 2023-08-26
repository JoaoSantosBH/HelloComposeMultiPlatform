package com.brq.kmm.features.details.presentation

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.brq.kmm.core.domain.Services
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieDetailsScreenModel(private val service: Services) : ScreenModel {

    private val _uiState: MutableStateFlow<MovieDetailsUiState> = MutableStateFlow(MovieDetailsUiState.Empty)
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
                when(event) {
                    MovieDetailsEvent.GetMovieDetails -> getMoviesDetail()
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

    }

    private fun unFavoriteMovie(id: Int) {
        
    }

    private fun favoriteMovie(id: Int) {
        
    }

    private fun finishLoading() {
        
    }

    private fun setLoading() {
        
    }

     fun getMoviesDetail() {
        
    }
}