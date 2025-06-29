package com.kmp.movie.presentation.ui.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.getValue
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.kmp.movie.design.bottombar.BottomNavigationBar
import com.kmp.movie.design.topbar.CenterTopBar
import com.kmp.movie.presentation.ui.setting.action.SettingAction
import com.kmp.movie.presentation.ui.setting.component.SettingDialogArea
import com.kmp.movie.presentation.ui.setting.component.SettingItem
import com.kmp.movie.presentation.ui.setting.state.SettingState
import com.kmp.movie.presentation.ui.setting.viewmodel.SettingViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SettingScreenRoute(
    navController: NavHostController,
    settingViewModel: SettingViewModel = koinViewModel(),
    onSelectTheme: (Boolean) -> Unit,
){
    val settingState by settingViewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = Unit) {
        settingViewModel.getIsLightTheme()
    }

    SettingDialogArea(
        isShowSelectThemeDialog = settingState.isShowSelectThemeDialog,
        isLightTheme = settingState.isLightTheme,
        onConfirm = {
            settingViewModel.onAction(SettingAction.OnShowSelectThemeDialog(isShow = false))
        },
        onSelectTheme = {
            onSelectTheme(it)
            settingViewModel.onAction(SettingAction.OnSelectTheme(it))
        }
    )
    SettingScreen(
        navController = navController,
        settingState = settingState,
        onGotoNavigateBack = { navController.popBackStack() },
        onAction = { action ->
            settingViewModel.onAction(action = action)
        },
    )
}

@Composable
private fun SettingScreen(
    navController: NavHostController,
    settingState: SettingState,
    onGotoNavigateBack: () -> Unit,
    onAction: (SettingAction) -> Unit,
){
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
        ,
        topBar = {
            CenterTopBar(
                title = {
                    Text(
                        text = "설정",
                        color = MaterialTheme.colorScheme.primary
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onGotoNavigateBack,
                    ){
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "back",
                            modifier = Modifier
                                .size(32.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        },
        //containerColor = MaterialTheme.colorScheme.background,
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
                title = "테마설정",
                isLightTheme = settingState.isLightTheme,
                onClick = {
                    onAction(SettingAction.OnShowSelectThemeDialog(isShow = true))
                }
            )
        }
    }
}