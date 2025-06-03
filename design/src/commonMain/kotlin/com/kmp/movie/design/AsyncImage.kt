package com.kmp.movie.design

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage

@Composable
fun AsyncImage(
    modifier: Modifier,
    urlString: String,
    radius: Dp = 16.dp
){
    SubcomposeAsyncImage(
        model = urlString,
        contentDescription = "image",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .clip(RoundedCornerShape(radius)),
        loading = {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        },
    )
}