package com.kmp.movie.core.presentation

import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings

sealed interface Screens {
    @Serializable
    data object Main: Screens
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
    @Serializable
    data object Setting: Screens
}

sealed class BottomBarScreen(
    val screen: Screens,
    val name: String,
    val icon: ImageVector,
){
    data object Home: BottomBarScreen(
        screen = Screens.Home,
        name = "홈",
        icon = Icons.Filled.Home
    )
    data object Setting: BottomBarScreen(
        screen = Screens.Setting,
        name = "설정",
        icon = Icons.Filled.Settings
    )
}

val bottomDestinations = listOf(
    BottomBarScreen.Home,
    BottomBarScreen.Setting,
)
