package com.brq.kmm.features.details.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import io.github.skeptick.libres.compose.painterResource
import io.github.skeptick.libres.images.Image

@Composable
fun CardStatisticLayout(
    contentText: String,
    icon: Image,
    title: String
) {
    val cardTitleColor = MaterialTheme.colorScheme.onBackground
    val surfaceColor = MaterialTheme.colorScheme.background

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Transparent)
            .padding(16.dp),
        border = BorderStroke(1.dp, Color.Gray),
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = surfaceColor)
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {


                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(image = icon),
                        contentDescription = null,
                        tint = cardTitleColor
                    )
                    Text(
                        text = title,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        modifier = Modifier.padding(start = 4.dp),
                        style = MaterialTheme.typography.labelMedium.copy(color = cardTitleColor)
                    )
                }
                Text(
                    contentText,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.padding(start= 4.dp, top = 8.dp),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    )
}