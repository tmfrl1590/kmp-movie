package com.kmp.movie.presentation.screen.search.state

import com.kmp.movie.presentation.model.SearchedMovieDataModel

data class SearchState(
    val inputText: String = "",
    val searchedMovieList: List<SearchedMovieDataModel> = emptyList(),
)
