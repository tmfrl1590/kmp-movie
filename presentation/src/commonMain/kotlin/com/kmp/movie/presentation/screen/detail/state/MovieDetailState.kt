package com.kmp.movie.presentation.screen.detail.state

import com.kmp.movie.presentation.model.DetailMovieModel
import com.kmp.movie.presentation.model.MovieCreditModel
import com.kmp.movie.presentation.model.RecommendMovieModel
import com.kmp.movie.presentation.model.SimilarMovieModel

data class MovieDetailState(
    val isLoading: Boolean = false,
    val movieDeDetailInfo: DetailMovieModel = DetailMovieModel(),
    val movieCredit: MovieCreditModel = MovieCreditModel(),
    val similarMovie: SimilarMovieModel = SimilarMovieModel(),
    val recommendMovie: RecommendMovieModel = RecommendMovieModel(),
)