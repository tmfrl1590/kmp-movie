package com.kmp.movie.presentation.ui.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.kmp.movie.core.Resources
import com.kmp.movie.design.bottombar.BottomNavigationBar
import com.kmp.movie.presentation.ui.setting.action.SettingAction
import com.kmp.movie.presentation.ui.setting.component.AppVersionArea
import com.kmp.movie.presentation.ui.setting.component.SettingDialogArea
import com.kmp.movie.presentation.ui.setting.component.SettingItem
import com.kmp.movie.presentation.ui.setting.component.SettingTopBar
import com.kmp.movie.presentation.ui.setting.viewmodel.SettingViewModel
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SettingScreenRoute(
    navController: NavHostController,
    isLightTheme: Boolean,
    settingViewModel: SettingViewModel = koinViewModel(),
    onSelectTheme: (Boolean) -> Unit,
){
    val settingState by settingViewModel.state.collectAsStateWithLifecycle()

    SettingDialogArea(
        isShowSelectThemeDialog = settingState.isShowSelectThemeDialog,
        isLightTheme = isLightTheme,
        onConfirm = {
            settingViewModel.onAction(SettingAction.OnShowSelectThemeDialog(isShow = false))
        },
        onSelectTheme = {
            onSelectTheme(it)
            settingViewModel.onAction(SettingAction.OnShowSelectThemeDialog(isShow = false))
        }
    )
    SettingScreen(
        navController = navController,
        isLightTheme = isLightTheme,
        onGotoNavigateBack = { navController.popBackStack() },
        onAction = { action ->
            settingViewModel.onAction(action = action)
        },
    )
}

@Composable
private fun SettingScreen(
    navController: NavHostController,
    isLightTheme: Boolean,
    onGotoNavigateBack: () -> Unit,
    onAction: (SettingAction) -> Unit,
){
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
        ,
        topBar = {
            SettingTopBar(
                onGotoNavigateBack = onGotoNavigateBack,
            )
        },
        bottomBar = {
            BottomNavigationBar(
                navController = navController
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 16.dp),
        ) {
            Spacer(
                modifier = Modifier
                    .height(12.dp)
            )
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
}