package com.kmp.movie.presentation.ui.setting.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kmp.movie.domain.usecase.local.GetIsLightThemeUseCase
import com.kmp.movie.domain.usecase.local.SaveIsLightThemeUseCase
import com.kmp.movie.presentation.ui.setting.action.SettingAction
import com.kmp.movie.presentation.ui.setting.state.SettingState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SettingViewModel(
    private val saveIsLightThemeUseCase: SaveIsLightThemeUseCase,
    private val getIsLightThemeUseCase: GetIsLightThemeUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(SettingState())
    val state = _state.asStateFlow()

    fun getIsLightTheme() {
        viewModelScope.launch(Dispatchers.IO) {
            val isLightTheme = getIsLightThemeUseCase()

            _state.update { it.copy(isLightTheme = isLightTheme) }
        }
    }

    fun saveIsLightTheme(isLightTheme: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            saveIsLightThemeUseCase(isLightTheme = isLightTheme)
        }
    }

    fun onAction(action: SettingAction) {
        when (action) {
            is SettingAction.OnShowSelectThemeDialog -> _state.update {
                it.copy(
                    isShowSelectThemeDialog = action.isShow
                )
            }

            is SettingAction.OnSelectTheme -> {
                saveIsLightTheme(isLightTheme = !action.isLightTheme)
                _state.update {
                    it.copy(
                        isLightTheme = action.isLightTheme,
                        isShowSelectThemeDialog = false
                    )
                 }
            }
        }
    }
}
