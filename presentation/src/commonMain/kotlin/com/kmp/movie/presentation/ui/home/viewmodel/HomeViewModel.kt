package com.kmp.movie.presentation.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kmp.movie.core.domain.onSuccess
import com.kmp.movie.domain.usecase.GetNowPlayingMovieListUseCase
import com.kmp.movie.domain.usecase.GetPopularMovieListUseCase
import com.kmp.movie.domain.usecase.GetUpComingMovieListUseCase
import com.kmp.movie.presentation.model.toHomeModel
import com.kmp.movie.presentation.model.toPresentation
import com.kmp.movie.presentation.ui.home.action.HomeAction
import com.kmp.movie.presentation.ui.home.state.HomeState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getNowPlayingMovieListUseCase: GetNowPlayingMovieListUseCase,
    private val getUpComingMovieListUseCase: GetUpComingMovieListUseCase,
    private val getPopularMovieListUseCase: GetPopularMovieListUseCase,
): ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    fun getNowPlayingMovieList(){
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch(Dispatchers.IO) {
            getNowPlayingMovieListUseCase(
                language = "ko",
                region = "KR",
                page = 1
            ).onSuccess { result ->
                val data = result.toPresentation()
                _state.update { it.copy(isLoading = false, homeMovieList = data.results.map { it.toHomeModel()}) }
            }
        }
    }

    fun getUpComingMovieList(){
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch(Dispatchers.IO) {
            getUpComingMovieListUseCase(
                language = "ko",
                region = "KR",
                page = 1
            ).onSuccess { result ->
                val data = result.toPresentation()
                _state.update { it.copy(isLoading = false, homeMovieList = data.results.map { it.toHomeModel()}) }
            }
        }
    }

    fun getPopularMovieList(){
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch(Dispatchers.IO) {
            getPopularMovieListUseCase(
                language = "ko",
                region = "KR",
                page = 1
            ).onSuccess { result ->
                val data = result.toPresentation()
                _state.update { it.copy(isLoading = false, homeMovieList = data.results.map { it.toHomeModel()}) }
            }
        }
    }

    fun onAction(action: HomeAction){
        when(action){
            is HomeAction.OnShowBottomSheet -> _state.update { it.copy(isShowBottomSheet = action.isShowSheet) }
            is HomeAction.OnSelectMovieType -> _state.update { it.copy(selectedMovieType = action.selectedMovieType, isShowBottomSheet = false) }
        }
    }
}