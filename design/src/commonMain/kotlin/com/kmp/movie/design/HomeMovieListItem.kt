package com.kmp.movie.design

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
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
fun HomeMovieListItem(
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
                .padding(bottom = 8.dp)
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
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier = Modifier.size(16.dp),
                imageVector = Icons.Filled.Star,
                contentDescription = "",
                tint = Color.Yellow
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = voteAverage.toString(),
                fontSize = 16.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "($voteCount)",
                fontSize = 12.sp,
                color = Color.White
            )
        }
    }
}