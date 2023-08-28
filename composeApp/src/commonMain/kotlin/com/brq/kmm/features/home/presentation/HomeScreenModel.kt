package com.brq.kmm.features.home.presentation

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.brq.kmm.core.domain.Services
import com.brq.kmm.features.details.domain.FavoriteMoviesDataSource
import com.brq.kmm.features.home.data.remote.MovieResponse.Companion.toDomain
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenModel(
    private val service:Services,
    val navigator: (Int) -> Unit,
    private val ds: FavoriteMoviesDataSource
) : ScreenModel {

    private val _uiState : MutableStateFlow<HomeUiStates> = MutableStateFlow(HomeUiStates.Empty)
    val uiState : StateFlow<HomeUiStates> = _uiState.asStateFlow()
    private val pendingActions = MutableSharedFlow<HomeEvent>()
    init {
        handleEvents()
    }

    fun onEvent(event: HomeEvent) {
        coroutineScope.launch {
            pendingActions.emit(event)
        }
    }

    private fun handleEvents() {
        coroutineScope.launch {
            pendingActions.collect { event ->
                when(event) {
                   is HomeEvent.OnClickCardMovieEvent -> navigator(event.movieId?:0)
                    is HomeEvent.OnClickExitEvent -> navigator(event.id?:0)
                    is HomeEvent.FavMoviesEvent -> filterFavMovies()
                    is HomeEvent.TabMoviesEvent -> filterAllMovies()
                }

            }
        }
    }

    fun getPopularMovies() {
        coroutineScope.launch {
            val result = service.getPopularMoviesList()
            if (result.isNotEmpty()) _uiState.update {
                val list = result.toDomain()
                it.copy(isLoading = false, popularMovies = result.toDomain(), cachedMovies = result.toDomain())
            }
            updateFavorites()
        }
    }

    private fun filterAllMovies() {
        _uiState.update { it.copy(popularMovies = _uiState.value.cachedMovies, isTabFavSelected = false) }

    }
    private fun updateFavorites() {
        var result: List<Int>
        coroutineScope.launch {
            result = ds.getFavoriteMoviesList()
            _uiState.update { it.copy(favoriteIds = result) }
        }
    }

    private fun filterFavMovies() {
        _uiState.update {
            it.copy(popularMovies = _uiState.value.popularMovies.filter {
                _uiState.value.favoriteIds.contains(
                    it.id
                )
            }, isTabFavSelected = true)
        }
    }
}