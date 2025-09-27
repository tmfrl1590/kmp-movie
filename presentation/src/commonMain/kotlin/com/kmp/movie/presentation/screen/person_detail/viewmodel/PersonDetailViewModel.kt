package com.kmp.movie.presentation.screen.person_detail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kmp.movie.core.domain.DataError
import com.kmp.movie.core.domain.onError
import com.kmp.movie.core.domain.onSuccess
import com.kmp.movie.domain.usecase.GetCombinedMovieUseCase
import com.kmp.movie.domain.usecase.GetPersonDetailUseCase
import com.kmp.movie.presentation.model.toPresentation
import com.kmp.movie.presentation.screen.person_detail.state.PersonDetailState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PersonDetailViewModel(
    private val getPersonDetailUseCase: GetPersonDetailUseCase,
    private val getCombinedMovieUseCase: GetCombinedMovieUseCase,
): ViewModel() {

    private val _state = MutableStateFlow(PersonDetailState())
    val state = _state.asStateFlow()

    private val _error = MutableSharedFlow<DataError>()
    val error = _error.asSharedFlow()

    fun getPersonDetailAndCombinedMovie(
        personId: Int,
    ){
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isLoading = true) }

            try {
                val personDetailDeferred = async { getPersonDetailUseCase(personId = personId, language = "ko") }
                val combinedMovieDeferred = async { getCombinedMovieUseCase(personId = personId, language = "ko") }

                val personDetailResult = personDetailDeferred.await()
                val combinedMovieResult = combinedMovieDeferred.await()

                personDetailResult
                    .onSuccess { result ->
                        val data = result.toPresentation()
                        _state.update { it.copy(personDetailInfo = data) }
                    }.onError { error ->
                        _error.emit(error)
                    }

                combinedMovieResult
                    .onSuccess { result ->
                        val data = result.toPresentation()
                        _state.update { it.copy(combinedMovieModel = data) }
                    }.onError { error ->
                        _error.emit(error)
                    }
            } finally {
                _state.update { it.copy(isLoading = false) }
            }
        }
    }
}