package com.kmp.movie.presentation.model

data class HomeMovieModel(
    val id: Int,
    val title: String,
    val posterPath: String,
    val voteAverage: Double,
    val voteCount: Int,
)
