package com.kmp.movie.presentation.ui.search.state

import com.kmp.movie.presentation.model.SearchedMovieDataModel

data class SearchState(
    val inputText: String = "",
    val searchedMovieList: List<SearchedMovieDataModel> = emptyList(),
)
