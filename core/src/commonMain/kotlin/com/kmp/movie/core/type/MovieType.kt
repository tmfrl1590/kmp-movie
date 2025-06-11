package com.kmp.movie.core.type

enum class MovieType(
    val displayName: String,
) {
    NOW_PLAYING("현재 상영 중"),
    UPCOMING("개봉 예정"),
    POPULAR("인기 작품")
}