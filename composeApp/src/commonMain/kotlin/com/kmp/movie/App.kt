package com.kmp.movie

import androidx.compose.runtime.Composable
import com.kmp.movie.design.KmpMovieTheme
import com.kmp.movie.presentation.AppNavHost
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    KmpMovieTheme {
        AppNavHost()
    }
}