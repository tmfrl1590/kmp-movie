package com.kmp.movie

import androidx.compose.ui.window.ComposeUIViewController
import com.kmp.movie.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }