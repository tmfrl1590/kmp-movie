package com.kmp.movie.domain.model

data class CombinedMovie(
    val cast: List<CombinedMovieItem>
)

data class CombinedMovieItem(
    val adult: Boolean,
    val backdropPath: String?,
    val genreIds: List<Int>,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int,
    val character: String?,
    val creditId: String,
    val order: Int,
    val mediaType: String
)