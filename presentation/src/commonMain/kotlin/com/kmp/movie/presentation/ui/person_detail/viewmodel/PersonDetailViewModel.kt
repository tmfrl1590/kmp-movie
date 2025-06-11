package com.kmp.movie.presentation.ui.person_detail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kmp.movie.core.domain.onSuccess
import com.kmp.movie.domain.usecase.GetCombinedMovieUseCase
import com.kmp.movie.domain.usecase.GetPersonDetailUseCase
import com.kmp.movie.presentation.model.toPresentation
import com.kmp.movie.presentation.ui.person_detail.state.PersonDetailState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PersonDetailViewModel(
    private val getPersonDetailUseCase: GetPersonDetailUseCase,
    private val getCombinedMovieUseCase: GetCombinedMovieUseCase,
): ViewModel() {

    private val _state = MutableStateFlow(PersonDetailState())
    val state = _state.asStateFlow()

    fun getPersonDetail(
        personId: Int,
    ){
        viewModelScope.launch(Dispatchers.IO) {
            getPersonDetailUseCase(
                personId = personId,
                language = "ko"
            ).onSuccess { result ->
                val data = result.toPresentation()
                _state.update { it.copy(personDetailInfo = data) }
            }
        }
    }

    fun getCombinedMovie(
        personId: Int,
    ){
        viewModelScope.launch(Dispatchers.IO) {
            getCombinedMovieUseCase(
                personId = personId,
                language = "ko"
            ).onSuccess { result ->
                val data = result.toPresentation()
                _state.update { it.copy(combinedMovieModel = data) }
            }
        }
    }
}