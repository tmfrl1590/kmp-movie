package com.kmp.movie.presentation.screen.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kmp.movie.domain.usecase.local.GetIsLightThemeUseCase
import com.kmp.movie.domain.usecase.local.SaveIsLightThemeUseCase
import com.kmp.movie.presentation.screen.app.state.AppState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppViewModel(
    private val saveIsLightThemeUseCase: SaveIsLightThemeUseCase,
    private val getIsLightThemeUseCase: GetIsLightThemeUseCase,
): ViewModel() {

    private val _isLightTheme = MutableStateFlow(AppState())
    val isLightTheme = _isLightTheme.asStateFlow()

    fun getIsLightTheme(){
        viewModelScope.launch(Dispatchers.IO) {
            val isLightTheme = getIsLightThemeUseCase()
            _isLightTheme.update { it.copy(isLightTheme = isLightTheme) }
        }
    }

    fun saveIsLightTheme(isLightTheme: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            saveIsLightThemeUseCase(isLightTheme = isLightTheme)
            _isLightTheme.update { it.copy(isLightTheme = isLightTheme) }
        }
    }
}