package com.kmp.movie.presentation.ui.setting.viewmodel

import androidx.lifecycle.ViewModel
import com.kmp.movie.presentation.ui.setting.action.SettingAction
import com.kmp.movie.presentation.ui.setting.state.SettingState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SettingViewModel() : ViewModel() {

    private val _state = MutableStateFlow(SettingState())
    val state = _state.asStateFlow()

    fun onAction(action: SettingAction) {
        when (action) {
            is SettingAction.OnShowSelectThemeDialog -> _state.update { it.copy(isShowSelectThemeDialog = action.isShow) }
        }
    }
}
