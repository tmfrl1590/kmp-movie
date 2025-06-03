package com.kmp.movie.presentation.model

import com.kmp.movie.domain.model.NowPlayingMovie
import com.kmp.movie.domain.model.NowPlayingMovieData

data class NowPlayingMovieModel(
    val results: List<NowPlayingMovieDataModel>
)

data class NowPlayingMovieDataModel(
    val id: Int,
    val title: String,
    val posterPath: String,
    val voteAverage: Double,
    val voteCount: Int
)

fun NowPlayingMovie.toPresentation(): NowPlayingMovieModel = NowPlayingMovieModel(
    results = results.map { it.toPresentation() }
)

fun NowPlayingMovieData.toPresentation(): NowPlayingMovieDataModel = NowPlayingMovieDataModel(
    id = id,
    title = title,
    posterPath = posterPath,
    voteAverage = voteAverage,
    voteCount = voteCount
)

fun NowPlayingMovieDataModel.toHomeModel(): HomeMovieModel = HomeMovieModel(
    id = id,
    title = title,
    posterPath = posterPath,
    voteAverage = voteAverage,
    voteCount = voteCount,
)