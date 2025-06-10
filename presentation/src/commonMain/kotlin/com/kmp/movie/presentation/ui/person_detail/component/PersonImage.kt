package com.kmp.movie.presentation.ui.person_detail.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kmp.movie.design.AsyncImage

@Composable
fun PersonImage(
    imageUrl: String,
){
    AsyncImage(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp),
        urlString = imageUrl,
        radius = 0.dp,
    )
}