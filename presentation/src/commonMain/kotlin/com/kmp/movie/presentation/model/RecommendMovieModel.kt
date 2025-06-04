package com.kmp.movie.presentation.model

import com.kmp.movie.domain.model.RecommendMovie
import com.kmp.movie.domain.model.RecommendMovieData

data class RecommendMovieModel(
    val results: List<RecommendMovieDataModel> = emptyList()
)

data class RecommendMovieDataModel(
    val id: Int,
    val title: String,
    val posterPath: String,
    val voteAverage: Double,
    val voteCount: Int
)

fun RecommendMovie.toPresentation(): RecommendMovieModel = RecommendMovieModel(
    results = results.map { it.toPresentation() }
)

fun RecommendMovieData.toPresentation(): RecommendMovieDataModel = RecommendMovieDataModel(
    id = id,
    title = title,
    posterPath = posterPath,
    voteAverage = voteAverage,
    voteCount = voteCount
)