package com.kmp.movie.presentation.ui.home.action

sealed interface HomeAction {
    data class OnShowBottomSheet(val isShowSheet: Boolean): HomeAction
    data class OnSelectMovieType(val selectedMovieType: String): HomeAction
}