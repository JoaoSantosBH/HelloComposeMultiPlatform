package com.brq.kmm.features.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.brq.kmm.MainRes
import com.brq.kmm.features.home.presentation.HomeEvent

@Composable
fun HomeContentContainer(
    paddingValues: PaddingValues,
    onEvent: (HomeEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxSize()
    ) {
        TabLayout(onEvent)
    }
}

@Composable
fun TabLayout(onEvent: (HomeEvent) -> Unit) {
    var tabIndex by remember { mutableStateOf(0) }

    val tabs = listOf(
        MainRes.string.tab_all_movies_title_text,
        MainRes.string.tab_favorite_movies_title_text
    )
    val selected = remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = tabIndex,
            containerColor = MaterialTheme.colorScheme.background,

            ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = {
                        Text(text = title,
                            color = if (tabIndex == index)  MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.onBackground
                    ) },
                    selected = tabIndex == index,
                    onClick = {
                        selected.value = !selected.value
                        tabIndex = index },
                )
            }
        }
        when (tabIndex) {
            0 -> onEvent.invoke(HomeEvent.TabMoviesEvent)
            1 ->  onEvent.invoke(HomeEvent.FavMoviesEvent)
        }
    }

}