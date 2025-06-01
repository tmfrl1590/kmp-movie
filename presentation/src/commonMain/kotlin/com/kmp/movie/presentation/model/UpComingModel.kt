package com.kmp.movie.presentation.model

import com.kmp.movie.domain.model.UpComingMovie
import com.kmp.movie.domain.model.UpComingMovieData

data class UpComingMovieModel(
    val results: List<UpComingMovieDataModel>
)

data class UpComingMovieDataModel(
    val title: String,
    val posterPath: String,
    val voteAverage: Double,
    val voteCount: Int
)

fun UpComingMovie.toPresentation(): UpComingMovieModel = UpComingMovieModel(
    results = results.map { it.toPresentation() }
)

fun UpComingMovieData.toPresentation(): UpComingMovieDataModel = UpComingMovieDataModel(
    title = title,
    posterPath = posterPath,
    voteAverage = voteAverage,
    voteCount = voteCount
)

fun UpComingMovieDataModel.toHomeModel(): HomeMovieModel = HomeMovieModel(
    title = title,
    posterPath = posterPath,
    voteAverage = voteAverage,
    voteCount = voteCount,
)