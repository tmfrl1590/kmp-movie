package com.kmp.movie.presentation.screen.search.action

sealed interface SearchAction {
    data class OnInputText(val inputText: String): SearchAction
    data object OnSearch: SearchAction
}