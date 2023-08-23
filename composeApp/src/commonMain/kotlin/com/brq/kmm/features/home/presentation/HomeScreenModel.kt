package com.brq.kmm.features.home.presentation

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeScreenModel : ScreenModel {

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
                   is HomeEvent.onClickCardMovieEvent -> println()
                    else -> println()
                }

            }
        }
    }
}