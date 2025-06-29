package com.kmp.movie.design

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val DarkColorScheme = darkColorScheme(
    primary = Color.Black,
    background = Color.White,
)

val LightColorScheme = lightColorScheme(
    primary = Color.White,
    background = Color.Black,
)

@Composable
fun KmpMovieTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit
){
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}