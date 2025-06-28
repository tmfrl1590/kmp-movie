package com.kmp.movie.presentation.ui.setting.state

data class SettingState(

    // 테마 선택 Dialog
    val isShowSelectThemeDialog: Boolean = false,

    // 라이트 테마인지 여부
    val isLightTheme: Boolean = false,

)