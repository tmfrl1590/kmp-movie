package com.kmp.movie.presentation.screen.detail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kmp.movie.core.domain.DataError
import com.kmp.movie.core.domain.onError
import com.kmp.movie.core.domain.onSuccess
import com.kmp.movie.domain.usecase.GetMovieCreditsUseCase
import com.kmp.movie.domain.usecase.GetMovieDetailUseCase
import com.kmp.movie.domain.usecase.GetRecommendMovieUseCase
import com.kmp.movie.domain.usecase.GetSimilarMovieUseCase
import com.kmp.movie.presentation.model.toPresentation
import com.kmp.movie.presentation.screen.detail.state.MovieDetailState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val getMovieCreditsUseCase: GetMovieCreditsUseCase,
    private val getSimilarMovieUseCase: GetSimilarMovieUseCase,
    private val getRecommendMovieUseCase: GetRecommendMovieUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(MovieDetailState())
    val state = _state.asStateFlow()

    private val _error = MutableSharedFlow<DataError>()
    val error = _error.asSharedFlow()

    fun loadMovieAllData(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isLoading = true) }

            try {
                val detailDeferred = async { getMovieDetailUseCase(movieId, "ko") }
                val creditDeferred = async { getMovieCreditsUseCase(movieId, "ko") }
                val similarDeferred = async { getSimilarMovieUseCase(movieId, "ko") }
                val recommendDeferred = async { getRecommendMovieUseCase(movieId, "ko") }

                val detailResult = detailDeferred.await()
                val creditResult = creditDeferred.await()
                val similarResult = similarDeferred.await()
                val recommendResult = recommendDeferred.await()

                detailResult
                    .onSuccess { result ->
                        _state.update { it.copy(movieDeDetailInfo = result.toPresentation()) }
                    }.onError { error ->
                        _error.emit(error)
                    }

                creditResult
                    .onSuccess { result ->
                        _state.update { it.copy(movieCredit = result.toPresentation()) }
                    }.onError { error ->
                        _error.emit(error)
                    }

                similarResult
                    .onSuccess { result ->
                        _state.update { it.copy(similarMovie = result.toPresentation()) }
                    }.onError { error ->
                        _error.emit(error)
                    }

                recommendResult
                    .onSuccess { result ->
                        _state.update { it.copy(recommendMovie = result.toPresentation()) }
                    }.onError { error ->
                        _error.emit(error)
                    }
            } finally {
                _state.update { it.copy(isLoading = false) }
            }
        }
    }
}