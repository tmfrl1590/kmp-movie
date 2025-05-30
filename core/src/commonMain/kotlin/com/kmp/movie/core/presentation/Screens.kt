package com.kmp.movie.core.presentation

import kotlinx.serialization.Serializable

sealed interface Screens {
    @Serializable
    data object Home: Screens
}