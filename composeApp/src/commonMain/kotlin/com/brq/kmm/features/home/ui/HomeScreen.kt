package com.brq.kmm.features.home.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.brq.kmm.features.home.presentation.HomeEvent
import com.brq.kmm.features.home.presentation.HomeScreenModel

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { HomeScreenModel() }

        val navigator = LocalNavigator.currentOrThrow
        val onEvent: (HomeEvent) -> Unit = { event ->
            println(event)
            viewModel.onEvent(event)
        }

        HomeLayout(onEvent)

        LaunchedEffect(key1 = null){}

    }


}