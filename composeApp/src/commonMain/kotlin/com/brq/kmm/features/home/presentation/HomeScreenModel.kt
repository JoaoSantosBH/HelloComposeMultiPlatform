package com.brq.kmm.features.home.presentation

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.brq.kmm.core.domain.Services
import com.brq.kmm.features.home.data.remote.MovieResponse.Companion.toDomain
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenModel(private val service:Services) : ScreenModel {

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
                   is HomeEvent.OnClickCardMovieEvent -> println()
                    else -> println()
                }

            }
        }
    }

    fun getPopularMovies() {
        coroutineScope.launch {
            val result = service.getPopularMoviesList()
            result.toDomain()
            if (result.isNotEmpty()) _uiState.update {
                it.copy(isLoading = false, popularMovies = result.toDomain())
            }
        }
    }
}