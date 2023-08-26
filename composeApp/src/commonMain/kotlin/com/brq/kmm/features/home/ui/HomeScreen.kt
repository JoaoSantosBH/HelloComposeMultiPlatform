package com.brq.kmm.features.home.ui

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
import com.brq.kmm.features.details.ui.MovieDetailsScreen
import com.brq.kmm.features.home.presentation.HomeEvent
import com.brq.kmm.features.home.presentation.HomeScreenModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeScreen : Screen, KoinComponent {

    @Composable
    override fun Content() {

        val services by inject<Services>()

        val navigator = LocalNavigator.currentOrThrow
        val navigate : (Int)-> Unit = { movieId ->
            navigator.push(MovieDetailsScreen(movieId))
        }
        val viewModel = rememberScreenModel { HomeScreenModel(services, navigate) }
        val state by remember { viewModel.uiState }.collectAsState()


        val onEvent: (HomeEvent) -> Unit = { event ->
            println(event)
            viewModel.onEvent(event)
        }

        HomeLayout(onEvent, state)

        LaunchedEffect(key1 = null) {
            viewModel.getPopularMovies()
        }

    }


}