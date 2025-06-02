package com.kmp.movie.presentation.model

import com.kmp.movie.domain.model.PopularMovie
import com.kmp.movie.domain.model.PopularMovieData

data class PopularMovieModel(
    val results: List<PopularMovieDataModel>
)

data class PopularMovieDataModel(
    val title: String,
    val posterPath: String,
    val voteAverage: Double,
    val voteCount: Int
)

fun PopularMovie.toPresentation(): PopularMovieModel = PopularMovieModel(
    results = results.map { it.toPresentation() }
)

fun PopularMovieData.toPresentation(): PopularMovieDataModel = PopularMovieDataModel(
    title = title,
    posterPath = posterPath,
    voteAverage = voteAverage,
    voteCount = voteCount
)

fun PopularMovieDataModel.toHomeModel(): HomeMovieModel = HomeMovieModel(
    title = title,
    posterPath = posterPath,
    voteAverage = voteAverage,
    voteCount = voteCount,
)