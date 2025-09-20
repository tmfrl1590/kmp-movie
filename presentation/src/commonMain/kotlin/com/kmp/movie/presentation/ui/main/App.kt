package com.kmp.movie.presentation.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kmp.movie.design.KmpMovieTheme
import com.kmp.movie.presentation.AppNavHost
import com.kmp.movie.presentation.ui.main.viewmodel.AppViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App(
    viewModel: AppViewModel = koinViewModel(),
    onFinishApp: () -> Unit = {},
) {
    val appState by viewModel.isLightTheme.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = Unit) {
        viewModel.getIsLightTheme()
    }

    KmpMovieTheme(isLightTheme = appState.isLightTheme) {
        AppNavHost(
            isLightTheme = appState.isLightTheme,
            onSelectTheme = { newTheme ->
                viewModel.saveIsLightTheme(newTheme)
            },
            onFinishApp = onFinishApp
        )
    }
}