package com.brq.kmm

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.brq.kmm.features.splash.SplashScreen
import com.brq.kmm.theme.AppTheme
import io.github.aakira.napier.Napier

@OptIn(ExperimentalAnimationApi::class)
@Composable
internal fun App() = AppTheme {

    Navigator(
        screen = SplashScreen(),
        onBackPressed = { currentScreen ->
            Napier.d("Pop screen #}", null, "Navigator")
            true
        }
    ) { navigator ->
        CurrentScreen()
        SlideTransition(navigator)
    }

}