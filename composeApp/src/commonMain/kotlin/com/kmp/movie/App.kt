package com.kmp.movie

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.kmp.movie.design.KmpMovieTheme
import com.kmp.movie.presentation.AppNavHost
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    var isLightTheme by remember {
        mutableStateOf(false)
    }

    KmpMovieTheme(
        darkTheme = isLightTheme,
    ) {
        AppNavHost(
            onSelectTheme = {
                isLightTheme = it
            }
        )
    }
}