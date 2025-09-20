package com.kmp.movie.presentation.ui.start

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.kmp.movie.core.presentation.BottomBarScreen
import com.kmp.movie.core.presentation.Screens
import com.kmp.movie.design.bottombar.BottomNavigationBar
import com.kmp.movie.design.bottombar.fromBottomRoute
import com.kmp.movie.presentation.PresentationConstant.ANIMATION_DURATION
import com.kmp.movie.presentation.ui.home.HomeScreenRoute
import com.kmp.movie.presentation.ui.home.action.HomeAction
import com.kmp.movie.presentation.ui.home.component.HomeTopBar
import com.kmp.movie.presentation.ui.home.state.HomeState
import com.kmp.movie.presentation.ui.home.viewmodel.HomeViewModel
import com.kmp.movie.presentation.ui.setting.SettingScreenRoute
import com.kmp.movie.presentation.ui.setting.component.SettingTopBar
import com.kmp.movie.presentation.ui.setting.viewmodel.SettingViewModel
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun StartScreenRoute(
    isLightTheme: Boolean,
    onSelectTheme: (Boolean) -> Unit,
    onGotoNavigateBack: () -> Unit,
    onGotoSearch: () -> Unit,
    homeViewModel: HomeViewModel = koinViewModel(),
    settingViewModel: SettingViewModel = koinViewModel(),
    onClickMovie: (Int) -> Unit,
    onFinishApp: () -> Unit,
) {
    val navController = rememberNavController()

    val backStackEntry = navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry.value.fromBottomRoute()

    val homeState by homeViewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
        ,
        topBar = {
            if(currentScreen == BottomBarScreen.Setting){
                SettingTopBar(
                    onGotoNavigateBack = onGotoNavigateBack,
                )
            } else if(currentScreen == BottomBarScreen.Home){
                HomeTopBar(
                    selectedMovieTypeText = stringResource(homeState.selectedMovieType.displayName),
                    onShowBottomSheet = {
                        homeViewModel.onAction(action = HomeAction.OnShowBottomSheet(it))
                    },
                    onGotoSearch = onGotoSearch
                )
            }
        },
        bottomBar = {
            BottomNavigationBar(
                currentScreen = currentScreen,
                navController = navController,
                onTabClick = { bottomBarScreen ->
                    navController.navigate(bottomBarScreen.screen){
                        popUpTo(navController.graph.findStartDestination().route!!){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ){ paddingValues ->
        BottomBarGraph(
            navController = navController,
            paddingValues = paddingValues,
            isLightTheme = isLightTheme,
            onSelectTheme = onSelectTheme,
            homeViewModel = homeViewModel,
            settingViewModel = settingViewModel,
            homeState = homeState,
            onClickMovie = onClickMovie,
            onFinishApp = onFinishApp
        )
    }
}

@Composable
fun BottomBarGraph(
    navController: NavHostController,
    paddingValues: PaddingValues,
    isLightTheme: Boolean,
    onSelectTheme: (Boolean) -> Unit,
    homeViewModel: HomeViewModel,
    settingViewModel: SettingViewModel,
    homeState: HomeState,
    onClickMovie: (Int) -> Unit,
    onFinishApp: () -> Unit,
){
    NavHost(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(paddingValues)
        ,
        navController = navController,
        startDestination = Screens.Start,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(ANIMATION_DURATION)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(ANIMATION_DURATION)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Up,
                animationSpec = tween(ANIMATION_DURATION)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Up,
                animationSpec = tween(ANIMATION_DURATION)
            )
        },
    ){
        navigation<Screens.Start>(
            startDestination = Screens.Home
        ){
            composable<Screens.Home> {
                HomeScreenRoute(
                    homeViewModel = homeViewModel,
                    homeState = homeState,
                    onClickMovie = onClickMovie,
                    onFinishApp = onFinishApp
                )
            }
            composable<Screens.Setting> {
                SettingScreenRoute(
                    isLightTheme = isLightTheme,
                    onSelectTheme = onSelectTheme,
                    settingViewModel = settingViewModel
                )
            }
        }
    }
}