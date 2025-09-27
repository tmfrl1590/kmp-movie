package com.kmp.movie.presentation.screen.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kmp.movie.core.domain.onSuccess
import com.kmp.movie.domain.usecase.GetSearchedMovieListUseCase
import com.kmp.movie.presentation.model.toPresentation
import com.kmp.movie.presentation.screen.search.action.SearchAction
import com.kmp.movie.presentation.screen.search.state.SearchState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel(
    private val getSearchedMovieListUseCase: GetSearchedMovieListUseCase
): ViewModel() {

    private val _state = MutableStateFlow(SearchState())
    val state = _state.asStateFlow()

    fun search(){
        viewModelScope.launch(Dispatchers.IO) {
            getSearchedMovieListUseCase(
                query = _state.value.inputText,
                language = "ko",
            ).onSuccess { result ->
                val data = result.toPresentation()
                _state.update { it.copy(searchedMovieList = data.results) }
            }
        }
    }

    fun onAction(action: SearchAction){
        when(action){
            is SearchAction.OnInputText -> _state.update { it.copy(inputText = action.inputText) }
            is SearchAction.OnSearch -> search()
        }
    }
}