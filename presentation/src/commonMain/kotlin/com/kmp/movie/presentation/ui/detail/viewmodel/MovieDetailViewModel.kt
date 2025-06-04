package com.kmp.movie.presentation.ui.detail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kmp.movie.core.domain.onSuccess
import com.kmp.movie.domain.usecase.GetMovieCreditsUseCase
import com.kmp.movie.domain.usecase.GetMovieDetailUseCase
import com.kmp.movie.domain.usecase.GetRecommendMovieUseCase
import com.kmp.movie.domain.usecase.GetSimilarMovieUseCase
import com.kmp.movie.presentation.model.toPresentation
import com.kmp.movie.presentation.ui.detail.state.MovieDetailState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val getMovieCreditsUseCase: GetMovieCreditsUseCase,
    private val getSimilarMovieUseCase: GetSimilarMovieUseCase,
    private val getRecommendMovieUseCase: GetRecommendMovieUseCase,
): ViewModel() {

    private val _state = MutableStateFlow(MovieDetailState())
    val state = _state.asStateFlow()

    fun getMovieDetail(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            getMovieDetailUseCase(
                movieId = movieId,
                language = "ko",
            ).onSuccess { result ->
                val data = result.toPresentation()
                _state.update { it.copy(movieDeDetailInfo = data) }
            }
        }
    }

    fun getMovieCredit(movieId: Int){
        viewModelScope.launch(Dispatchers.IO) {
            getMovieCreditsUseCase(
                movieId = movieId,
                language = "ko",
            ).onSuccess { result ->
                val data = result.toPresentation()
                _state.update { it.copy(movieCredit = data) }
            }
        }
    }

    fun getSimilarMovie(movieId: Int){
        viewModelScope.launch(Dispatchers.IO) {
            getSimilarMovieUseCase(
                movieId = movieId,
                language = "ko",
            ).onSuccess { result ->
                val data = result.toPresentation()
                _state.update { it.copy(similarMovie = data) }
            }
        }
    }

    fun getRecommendMovie(movieId: Int){
        viewModelScope.launch(Dispatchers.IO) {
            getRecommendMovieUseCase(
                movieId = movieId,
                language = "ko",
            ).onSuccess { result ->
                val data = result.toPresentation()
                _state.update { it.copy(recommendMovie = data) }
            }
        }
    }
}