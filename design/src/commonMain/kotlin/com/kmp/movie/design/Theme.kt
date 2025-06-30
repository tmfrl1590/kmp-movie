package com.kmp.movie.design

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val DarkColorScheme = darkColorScheme(
    primary = White,
    background = Black,
    onBackground = Color.Gray,
)

val LightColorScheme = lightColorScheme(
    primary = Black,
    background = White,
    onBackground = Color.LightGray
)

@Composable
fun KmpMovieTheme(
    isLightTheme: Boolean,
    content: @Composable () -> Unit
){
    val colorScheme = if (isLightTheme) LightColorScheme else DarkColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}