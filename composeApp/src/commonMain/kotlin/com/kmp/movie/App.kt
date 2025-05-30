package com.kmp.movie

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.kmp.movie.presentation.AppNavHost
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        AppNavHost()
    }
}