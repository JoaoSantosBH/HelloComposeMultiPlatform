package com.brq.kmm.features.details.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.brq.kmm.MainRes
import com.brq.kmm.core.components.LoadingLayout
import com.brq.kmm.core.data.NetworkUtils
import com.brq.kmm.features.details.presentation.MovieDetailsEvent
import com.brq.kmm.features.details.presentation.MovieDetailsUiState
import com.seiko.imageloader.ImageRequestState
import com.seiko.imageloader.rememberAsyncImagePainter
import io.github.skeptick.libres.compose.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesDetailLayout(
    onEvent: (MovieDetailsEvent) -> Unit,
    state: MovieDetailsUiState,
    popNavigation: () -> Unit,
) {

    Scaffold(
        content = { paddingValues ->
            if (state.isLoading) LoadingLayout(paddingValues)
            else DetailsLayout(paddingValues, state, onEvent,popNavigation)
        }
    )
}

@Composable
fun DetailsLayout(
    paddingValues: PaddingValues,
    state: MovieDetailsUiState,
    onEvent: (MovieDetailsEvent) -> Unit,
    popNavigation: () -> Unit,
) {

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        LazyColumn {
            item {
                Box(modifier = Modifier.fillMaxWidth()) {
                    val url = (NetworkUtils.PATH_PREFIX_URL + state.movie.posterPath) ?: ""
                    val painter = rememberAsyncImagePainter(url)
                    if (painter.requestState == ImageRequestState.Success)
                        Image(
                            painter,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillWidth,
                            contentDescription = state.movie.title
                        )
                    Box(modifier = Modifier.padding(start = 8.dp, top = 16.dp, end = 16.dp)) {
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Image(
                                painter = painterResource(MainRes.image.ic_back_button),
                                modifier = Modifier
                                    .testTag("backButton")
                                    .size(42.dp)
                                    .clickable { popNavigation.invoke() },
                                contentDescription = null
                            )
                            Image(
                                modifier = Modifier
                                    .size(42.dp)
                                    .clickable {
                                        if (state.isFavorite)
                                            onEvent(MovieDetailsEvent.UnFavoriteMovie(state.movie.id.toString()))
                                        else
                                            onEvent(MovieDetailsEvent.FavoriteMovie(state.movie.id.toString()))
                                    },
                                painter = if (state.isFavorite) painterResource(MainRes.image.ic_heart_filled) else painterResource(MainRes.image.ic_heart_not_filled),
                                contentDescription = null
                            )
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = state.movie.title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleLarge.copy(color = Color.White)
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = MainRes.string.sinopse_text,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.labelLarge.copy(color = Color.Red)
                )
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = state.movie.overview,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            item { CardDetails(state) }
        }
    }

}

@Composable
fun CardDetails(state: MovieDetailsUiState) {
    val firstCardIcon = MainRes.image.ic_first_card
    val secondCardIcon = MainRes.image.ic_second_card
    val thirdCardIcon = MainRes.image.ic_third_card
    val fourthCardIcon = MainRes.image.ic_fourth_card

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CardStatisticLayout(
                state.movie.popularity.toString(),
                firstCardIcon,
                MainRes.string.first_card_title
            )
            Spacer(modifier = Modifier.height(16.dp))
            CardStatisticLayout(
                state.movie.release_date,
                thirdCardIcon,
                MainRes.string.third_card_title
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CardStatisticLayout(
                state.movie.voteAverage.toString(),
                secondCardIcon,
                MainRes.string.second_card_title
            )
            Spacer(modifier = Modifier.height(16.dp))
            CardStatisticLayout(
                state.movie.overview,
                fourthCardIcon,
                MainRes.string.fourth_card_title
            )
        }
    }
}