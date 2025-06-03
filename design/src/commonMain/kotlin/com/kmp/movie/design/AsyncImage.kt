package com.kmp.movie.design

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun AsyncImage(
    modifier: Modifier,
    urlString: String,
    radius: Dp = 16.dp
){
    AsyncImage(
        modifier = modifier
            .clip(RoundedCornerShape(radius)),
        model = urlString,
        //placeholder = painterResource(Res.drawable.placeholder_ic),
        alignment = Alignment.CenterStart,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        //error = painterResource(Res.drawable.placeholder_ic),
        onLoading = {
            //isLoading = true
        },
        onError = {
            it.result.throwable.printStackTrace()
        },
        onSuccess = {
            //isLoading = false
        }
    )
}