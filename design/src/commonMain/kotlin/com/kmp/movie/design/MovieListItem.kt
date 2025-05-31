package com.kmp.movie.design

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MovieListItem(
    modifier: Modifier,
    urlString: String,
    title: String,
    voteAverage: Double,
    voteCount: Int,
){
    Column(
        modifier = modifier
    ) {
        AsyncImage(
            urlString = urlString,
            modifier = Modifier
                .height(240.dp)
        )

        Text(
            text = title,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "평점 ",
                modifier = Modifier.alignByBaseline(),
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.White
                ),
            )
            Text(
                text = voteAverage.toString(),
                modifier = Modifier.alignByBaseline(),
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.White
                ),
            )

            Text(
                text = "($voteCount)",
                modifier = Modifier.alignByBaseline(),
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.White
                ),
            )
        }
    }
}