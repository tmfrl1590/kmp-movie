package com.kmp.movie.core.type

import com.kmp.movie.core.Resources
import org.jetbrains.compose.resources.StringResource

enum class MovieType(
    val displayName: StringResource,
) {
    NOW_PLAYING(Resources.String.now_playing),
    UPCOMING(Resources.String.upcoming),
    POPULAR(Resources.String.popular)
}