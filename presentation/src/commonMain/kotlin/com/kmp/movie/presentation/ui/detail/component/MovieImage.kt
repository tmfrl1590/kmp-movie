package com.kmp.movie.presentation.ui.detail.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kmp.movie.design.AsyncImage
import com.kmp.movie.design.error.ErrorLoadingMovie

@Composable
fun MovieImage(
    imageUrl: String,
) {
    AsyncImage(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp),
        urlString = imageUrl,
        radius = 0.dp,
        errorImage = {
            ErrorLoadingMovie()
        }
    )
}