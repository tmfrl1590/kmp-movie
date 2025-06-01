package com.kmp.movie.presentation.ui.home.action

import com.kmp.movie.presentation.type.MovieType

sealed interface HomeAction {
    data class OnShowBottomSheet(val isShowSheet: Boolean): HomeAction
    data class OnSelectMovieType(val selectedMovieType: MovieType): HomeAction
}