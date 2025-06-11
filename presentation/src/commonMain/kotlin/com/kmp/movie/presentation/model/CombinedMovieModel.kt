package com.kmp.movie.presentation.model

import com.kmp.movie.domain.model.CombinedMovie
import com.kmp.movie.domain.model.CombinedMovieItem

data class CombinedMovieModel(
    val cast: List<CombinedMovieItemModel> = emptyList()
)

data class CombinedMovieItemModel(
    val id: Int = 0,
    val title: String = "",
    val posterPath: String = "",
    val voteAverage: Double = 0.0,
    val voteCount: Int = 0,
)

fun CombinedMovie.toPresentation(): CombinedMovieModel = CombinedMovieModel(
    cast = cast.map { it.toPresentation() }

)

fun CombinedMovieItem.toPresentation(): CombinedMovieItemModel = CombinedMovieItemModel(
    id = id,
    title = title,
    posterPath = posterPath,
    voteAverage = voteAverage,
    voteCount = voteCount,
)