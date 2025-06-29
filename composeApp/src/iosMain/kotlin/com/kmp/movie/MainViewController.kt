package com.kmp.movie

import androidx.compose.ui.window.ComposeUIViewController
import com.kmp.movie.di.initKoin
import com.kmp.movie.presentation.ui.main.App

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }