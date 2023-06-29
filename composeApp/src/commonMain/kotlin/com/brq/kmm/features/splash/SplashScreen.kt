package com.brq.kmm.features.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.brq.kmm.features.login.LoginScreen
import kotlinx.coroutines.delay

class SplashScreen : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        SplashLayout()

        LaunchedEffect(true) {
            delay(2000)
            navigator.push(LoginScreen())
        }

    }

}

