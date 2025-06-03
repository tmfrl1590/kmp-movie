package com.kmp.movie.presentation.model

import com.kmp.movie.domain.model.SearchMovie
import com.kmp.movie.domain.model.SearchMovieData

data class SearchedMovieModel(
    val results: List<SearchedMovieDataModel>
)

data class SearchedMovieDataModel(
    val id: Int,
    val title: String,
    val posterPath: String,
    val voteAverage: Double,
    val voteCount: Int
)

fun SearchMovie.toPresentation(): SearchedMovieModel = SearchedMovieModel(
    results = results.map { it.toPresentation() }
)

fun SearchMovieData.toPresentation(): SearchedMovieDataModel = SearchedMovieDataModel(
    id = id,
    title = title,
    posterPath = posterPath,
    voteAverage = voteAverage,
    voteCount = voteCount
)