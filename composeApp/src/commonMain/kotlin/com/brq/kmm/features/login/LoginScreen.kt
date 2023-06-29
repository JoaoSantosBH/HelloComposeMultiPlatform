package com.brq.kmm.features.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class LoginScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val viewModel = rememberScreenModel { LoginScreenModel() }
        val state by remember { viewModel.uiSTate }.collectAsState()

        val onEvent: (LoginEvent) -> Unit = { eve ->
            viewModel.onEvent(eve)
        }

        LoginLayout(onEvent, state)

        SideEffect {
            if (state.isSuccessLogin) {
                navigator.pop()
            } else {
                if (state.allFieldsAreFilled && state.isSuccessLogin.not()) { }
            }
        }
        LaunchedEffect(state) {
        }
    }

}