package com.kmp.movie.presentation.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kmp.movie.core.domain.onSuccess
import com.kmp.movie.domain.usecase.GetNowPlayingMovieListUseCase
import com.kmp.movie.presentation.model.toPresentation
import com.kmp.movie.presentation.ui.home.state.HomeState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getNowPlayingMovieListUseCase: GetNowPlayingMovieListUseCase
): ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    init {
        getNowPlayingMovieList()
    }

    fun getNowPlayingMovieList(){
        viewModelScope.launch(Dispatchers.IO) {
            getNowPlayingMovieListUseCase(
                language = "ko",
                region = "KR",
                page = 1
            ).onSuccess { result ->
                val data = result.toPresentation()
                _state.update { it.copy(nowPlayingMovieList = data.results) }
            }
        }
    }
}