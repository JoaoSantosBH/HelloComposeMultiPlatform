package com.brq.kmm.features.login.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.brq.kmm.features.home.ui.HomeScreen
import com.brq.kmm.features.login.presentation.LoginEvent
import com.brq.kmm.features.login.presentation.LoginScreenModel

class LoginScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val navigate : ()-> Unit = {
            navigator.replace(HomeScreen())
        }
        val viewModel = rememberScreenModel { LoginScreenModel(navigate) }
        val state by remember { viewModel.uiSTate }.collectAsState()

        val onEvent: (LoginEvent) -> Unit = { event ->
            viewModel.onEvent(event)
        }

        LoginLayout(onEvent, state)

    }

}