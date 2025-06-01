package com.kmp.movie.presentation.ui.home.state

import com.kmp.movie.presentation.model.HomeMovieModel
import com.kmp.movie.presentation.type.MovieType

data class HomeState(
    // BottomSheet 여부
    val isShowBottomSheet: Boolean = false,

    // 현재 선택된 영화 타입
    val selectedMovieType: MovieType = MovieType.NOW_PLAYING,

    // 서버로부터 받아온 영화 리스트 (영화 타입에 맞게)
    val homeMovieList: List<HomeMovieModel> = emptyList(),
)
