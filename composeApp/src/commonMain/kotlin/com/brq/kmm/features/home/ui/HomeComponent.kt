package com.brq.kmm.features.home.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.brq.kmm.core.components.HomeToolBarCompose
import com.brq.kmm.features.home.domain.MovieModel
import com.brq.kmm.features.home.presentation.HomeEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeLayout(
    onEvent: (HomeEvent) -> Unit
) {

    Scaffold(
        topBar = { HomeToolBarCompose(onEvent) },
        content = { paddingValues ->
            HomeContentContainer(paddingValues, onEvent, MovieModel.DUMB_LIST_POPULAR)
        }
    )
}