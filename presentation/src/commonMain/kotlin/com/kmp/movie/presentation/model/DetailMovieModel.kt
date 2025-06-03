package com.kmp.movie.presentation.model

import com.kmp.movie.domain.model.DetailMovie

data class DetailMovieModel(
    val adult: Boolean = false,
    val backdropPath: String = "",
    val genres: List<String> = emptyList(),
    val id: Int = -1,
    val overview: String = "",
    val posterPath: String = "",
    val releaseDate: String = "",
    val runtime: String = "",
    val status: String = "",
    val title: String = "",
    val voteAverage: Double = 0.0,
    val voteCount: Int = 0
)

fun DetailMovie.toPresentation(): DetailMovieModel = DetailMovieModel(
    adult = adult,
    backdropPath = backdropPath,
    genres = genres.map { it.name },
    id = id,
    overview = overview,
    posterPath = posterPath,
    releaseDate = releaseDate,
    runtime = "${runtime}분",
    status = status,
    title = title,
    voteAverage = voteAverage,
    voteCount = voteCount
)