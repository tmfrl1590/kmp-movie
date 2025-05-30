package com.kmp.movie.presentation.ui.home.state

import com.kmp.movie.presentation.model.NowPlayingMovieDataModel

data class HomeState(
    val nowPlayingMovieList: List<NowPlayingMovieDataModel> = emptyList()
)
