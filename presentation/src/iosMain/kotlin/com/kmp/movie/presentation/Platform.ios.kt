package com.kmp.movie.presentation

import androidx.compose.runtime.Composable
import platform.Foundation.NSBundle

actual fun getAppVersion(): String {
    val version = NSBundle.mainBundle.infoDictionary?.get("CFBundleShortVersionString") as? String
    return version ?: "Unknown"
}

@Composable
actual fun BackHandlerUtil(enabled: Boolean, onBack: () -> Unit) {
}

@Composable
actual fun ShowToastMessage(message: String) {
}