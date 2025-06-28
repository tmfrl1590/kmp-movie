package com.kmp.movie.presentation.ui.setting.component

import androidx.compose.runtime.Composable
import com.kmp.movie.design.dialog.SelectThemeDialog

@Composable
fun SettingDialogArea(
    isShowSelectThemeDialog: Boolean,
    isLightTheme: Boolean,
    onConfirm: () -> Unit,
    onSelectTheme: (Boolean) -> Unit,
){
    if(isShowSelectThemeDialog){
        SelectThemeDialog(
            isLightTheme = isLightTheme,
            onConfirm = onConfirm,
            onSelectTheme = onSelectTheme,
        )
    }
}