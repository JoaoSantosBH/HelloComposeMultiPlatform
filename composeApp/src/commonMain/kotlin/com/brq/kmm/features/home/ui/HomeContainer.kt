package com.brq.kmm.features.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
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
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.brq.kmm.MainRes
import com.brq.kmm.core.components.ImageLoaderImage
import com.brq.kmm.core.data.NetworkUtils.Companion.PATH_PREFIX_URL
import com.brq.kmm.features.home.domain.MovieModel
import com.brq.kmm.features.home.presentation.HomeEvent

const val mangaAspectRatio = 12.8F / 18.2F

@Composable
fun HomeContentContainer(
    paddingValues: PaddingValues,
    onEvent: (HomeEvent) -> Unit,
    cards: List<MovieModel>
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxSize()
    ) {
        TabLayout(onEvent)
        Spacer(Modifier.height(8.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(cards) { card ->
                CardMovie(onEvent, card)
            }
        }

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
        TabRow(
            selectedTabIndex = tabIndex,
            containerColor = MaterialTheme.colorScheme.background,

            ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = {
                        Text(
                            text = title,
                            color = if (tabIndex == index) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.onBackground
                        )
                    },
                    selected = tabIndex == index,
                    onClick = {
                        selected.value = !selected.value
                        tabIndex = index
                    },
                )
            }
        }
        when (tabIndex) {
            0 -> onEvent.invoke(HomeEvent.TabMoviesEvent)
            1 -> onEvent.invoke(HomeEvent.FavMoviesEvent)
        }
    }

}

@Composable
fun CardMovie(onEvent: (HomeEvent) -> Unit, card: MovieModel) {
    Card(modifier = Modifier.testTag("cardMovie${card.id}").size(250.dp).clickable {
            onEvent(HomeEvent.OnClickCardMovieEvent(card.id))
        }) {

        val modifier = Modifier
        ImageLoaderImage(
            data = card,
            url = (PATH_PREFIX_URL + card.posterPath),
            contentDescription = card.title,
            modifier = Modifier,
            errorModifier = modifier then Modifier.aspectRatio(
                ratio = mangaAspectRatio,
                matchHeightConstraintsFirst = true,
            ),
            filterQuality = FilterQuality.Medium,
        )
    }
}