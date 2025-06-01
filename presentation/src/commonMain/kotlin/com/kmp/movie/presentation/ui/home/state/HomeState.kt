package com.kmp.movie.presentation.ui.home.state

import com.kmp.movie.presentation.model.NowPlayingMovieDataModel
import com.kmp.movie.presentation.model.UpComingMovieDataModel

data class HomeState(
    val isShowBottomSheet: Boolean = false,
    val selectedMovieType: String = "상영중인 영화",
    val nowPlayingMovieList: List<NowPlayingMovieDataModel> = emptyList(),
    val upComingMovieList: List<UpComingMovieDataModel> = emptyList(),
)
