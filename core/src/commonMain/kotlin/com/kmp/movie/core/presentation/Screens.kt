package com.kmp.movie.core.presentation

import kotlinx.serialization.Serializable

sealed interface Screens {
    @Serializable
    data object Home: Screens
    @Serializable
    data object Search: Screens
    @Serializable
    data class Detail(
        val movieId: Int
    ): Screens
    @Serializable
    data class PersonDetail(
        val personId: Int
    ): Screens
}