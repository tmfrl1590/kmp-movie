package com.kmp.movie.presentation.model

import com.kmp.movie.domain.model.SimilarMovie
import com.kmp.movie.domain.model.SimilarMovieData

data class SimilarMovieModel(
    val results: List<SimilarMovieDataModel> = emptyList()
)

data class SimilarMovieDataModel(
    val id: Int,
    val title: String,
    val posterPath: String,
    val voteAverage: Double,
    val voteCount: Int
)

fun SimilarMovie.toPresentation(): SimilarMovieModel = SimilarMovieModel(
    results = results.map { it.toPresentation() }
)

fun SimilarMovieData.toPresentation(): SimilarMovieDataModel = SimilarMovieDataModel(
    id = id,
    title = title,
    posterPath = posterPath,
    voteAverage = voteAverage,
    voteCount = voteCount
)

