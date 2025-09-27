package com.kmp.movie.presentation.screen.home.action

import com.kmp.movie.core.type.MovieType

sealed interface HomeAction {
    data class OnShowBottomSheet(val isShowSheet: Boolean): HomeAction
    data class OnSelectMovieType(val selectedMovieType: MovieType): HomeAction
}