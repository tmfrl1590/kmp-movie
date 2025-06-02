package com.kmp.movie.presentation.ui.search.action

sealed interface SearchAction {
    data class OnInputText(val inputText: String): SearchAction
    data object OnSearch: SearchAction
}