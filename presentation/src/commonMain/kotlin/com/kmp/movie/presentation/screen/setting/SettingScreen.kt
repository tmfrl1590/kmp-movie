package com.kmp.movie.presentation.screen.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kmp.movie.core.Resources
import com.kmp.movie.presentation.screen.setting.action.SettingAction
import com.kmp.movie.presentation.screen.setting.component.AppVersionArea
import com.kmp.movie.presentation.screen.setting.component.SettingDialogArea
import com.kmp.movie.presentation.screen.setting.component.SettingItem
import com.kmp.movie.presentation.screen.setting.viewmodel.SettingViewModel
import org.jetbrains.compose.resources.stringResource

@Composable
fun SettingScreenRoute(
    isLightTheme: Boolean,
    settingViewModel: SettingViewModel,
    onSelectTheme: (Boolean) -> Unit,
){
    val settingState by settingViewModel.state.collectAsStateWithLifecycle()

    SettingDialogArea(
        isShowSelectThemeDialog = settingState.isShowSelectThemeDialog,
        isLightTheme = isLightTheme,
        onConfirm = { settingViewModel.onAction(SettingAction.OnShowSelectThemeDialog(isShow = false)) },
        onSelectTheme = {
            onSelectTheme(it)
            settingViewModel.onAction(SettingAction.OnShowSelectThemeDialog(isShow = false))
        }
    )
    SettingScreen(
        isLightTheme = isLightTheme,
        onAction = { action ->
            settingViewModel.onAction(action = action)
        },
    )
}

@Composable
private fun SettingScreen(
    isLightTheme: Boolean,
    onAction: (SettingAction) -> Unit,
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {
        SettingItem(
            title = stringResource(Resources.String.setting_theme),
            isLightTheme = isLightTheme,
            onClick = {
                onAction(SettingAction.OnShowSelectThemeDialog(isShow = true))
            }
        )

        AppVersionArea()
    }
}