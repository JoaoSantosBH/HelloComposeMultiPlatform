package com.brq.kmm.features.details.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.brq.kmm.core.domain.Services
import com.brq.kmm.features.details.domain.FavoriteMoviesDataSource
import com.brq.kmm.features.details.presentation.MovieDetailsEvent
import com.brq.kmm.features.details.presentation.MovieDetailsScreenModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MovieDetailsScreen(val movieId: Int) : Screen, KoinComponent {
    @Composable
    override fun Content() {

        val services by inject<Services>()
        val ds by inject<FavoriteMoviesDataSource>()
        val viewModel = rememberScreenModel { MovieDetailsScreenModel(services,ds) }
        val state by remember { viewModel.uiState }.collectAsState()

        val navigator = LocalNavigator.currentOrThrow

        val onEvent: (MovieDetailsEvent) -> Unit = { event ->
            println(event)
            viewModel.onEvent(event)
        }

        val pop: ()-> Unit  = { navigator.pop() }

        MoviesDetailLayout(onEvent, state, pop)

        LaunchedEffect(key1 = null) {
            viewModel.getMoviesDetail(movieId)
        }
    }
}