package com.kmp.movie.presentation.ui.setting.action

sealed interface SettingAction {

    data class OnShowSelectThemeDialog(val isShow: Boolean): SettingAction
}