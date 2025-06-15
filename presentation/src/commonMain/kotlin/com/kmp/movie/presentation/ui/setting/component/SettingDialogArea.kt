package com.kmp.movie.presentation.ui.setting.component

import androidx.compose.runtime.Composable
import com.kmp.movie.design.dialog.SelectThemeDialog

@Composable
fun SettingDialogArea(
    isShowSelectThemeDialog: Boolean,
    onConfirm: () -> Unit,
){
    if(isShowSelectThemeDialog){
        SelectThemeDialog(
            onConfirm = onConfirm
        )
    }
}