package com.kmp.movie.presentation

import androidx.compose.runtime.Composable

expect fun getAppVersion(): String

@Composable
expect fun BackHandlerUtil(
    enabled: Boolean = true,
    onBack: () -> Unit
)

@Composable
expect fun ShowToastMessage(message: String)