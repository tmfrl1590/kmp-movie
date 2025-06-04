package com.kmp.movie.domain.model

data class RecommendMovie(
    val results: List<RecommendMovieData>
)

data class RecommendMovieData(
    val adult: Boolean,

    val backdropPath: String,

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

    val voteCount: Int
)