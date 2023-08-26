package com.brq.kmm.features.details.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.brq.kmm.features.details.presentation.MovieDetailsEvent
import com.brq.kmm.features.details.presentation.MovieDetailsUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesDetailLayout(
    onEvent: (MovieDetailsEvent) -> Unit,
    state: MovieDetailsUiState
) {

    Scaffold(
//        topBar = {  },
        content = { paddingValues ->
            Text("Detalhes do Filme")
        }
    )
}