package com.kmp.movie.presentation.ui.detail.state

import com.kmp.movie.presentation.model.DetailMovieModel
import com.kmp.movie.presentation.model.MovieCreditModel

data class MovieDetailState(
    val movieDeDetailInfo: DetailMovieModel = DetailMovieModel(),
    val movieCredit: MovieCreditModel = MovieCreditModel()
)