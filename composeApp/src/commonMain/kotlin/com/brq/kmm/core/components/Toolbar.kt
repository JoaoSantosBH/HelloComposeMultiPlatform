package com.brq.kmm.core.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.brq.kmm.MainRes
import com.brq.kmm.features.home.presentation.HomeEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeToolBarCompose(
    onEvent: (HomeEvent) -> Unit
) {

    TopAppBar(
        title = {
            Text(
                MainRes.string.home_title_app_bar,
                maxLines = 1,
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black,
                overflow = TextOverflow.Ellipsis
            )
        },

        actions = {
            IconButton(
                onClick = { onEvent(HomeEvent.OnClickExitEvent(-555)) }
            ) {
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = null,
                    tint =  MaterialTheme.colorScheme.primary
                )
            }


        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.background)
    )
}
