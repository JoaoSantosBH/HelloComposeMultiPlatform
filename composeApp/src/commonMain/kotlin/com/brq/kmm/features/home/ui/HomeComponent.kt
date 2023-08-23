package com.brq.kmm.features.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.brq.kmm.MainRes
import com.brq.kmm.core.components.HomeToolBarCompose
import com.brq.kmm.features.home.presentation.HomeEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeLayout(
    onEvent: (HomeEvent) -> Unit
) {

    Scaffold(
        topBar = { HomeToolBarCompose(onEvent) },
        content = { paddin ->
            Box(modifier = Modifier.fillMaxSize().background(color = Color.Yellow)) {
                Column(verticalArrangement = Arrangement.Center) {
                    Text(MainRes.string.fail_login_text)
                }
            }

        }
    )
}