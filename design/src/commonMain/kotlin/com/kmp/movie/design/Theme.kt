package com.kmp.movie.design

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val DarkColorScheme = darkColorScheme(
    primary = Color.White,
    background = Color.Black,
)

val LightColorScheme = lightColorScheme(
    primary = Color.Black,
    background = Color.White,
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