package com.kmp.movie.presentation.screen.setting.action

sealed interface SettingAction {
    data class OnShowSelectThemeDialog(val isShow: Boolean): SettingAction
}