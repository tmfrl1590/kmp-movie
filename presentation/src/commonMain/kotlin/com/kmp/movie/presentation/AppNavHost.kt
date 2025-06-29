package com.kmp.movie.presentation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.kmp.movie.core.presentation.Screens
import com.kmp.movie.presentation.ui.detail.MovieDetailScreenRoute
import com.kmp.movie.presentation.ui.home.HomeScreenRoute
import com.kmp.movie.presentation.ui.person_detail.PersonDetailScreenRoute
import com.kmp.movie.presentation.ui.search.SearchScreenRoute
import com.kmp.movie.presentation.ui.setting.SettingScreenRoute

const val ANIMATION_DURATION = 500

@Composable
fun AppNavHost(
    isLightTheme: Boolean,
    onSelectTheme: (Boolean) -> Unit,
) {
    val navController = rememberNavController()
    val snackBarHostState = remember { SnackbarHostState() }

    NavHost(
        navController = navController,
        startDestination = Screens.Home,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(ANIMATION_DURATION)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Down,
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
        composable<Screens.Home> {
            HomeScreenRoute(
                navController = navController
            )
        }
        composable<Screens.Search> {
            SearchScreenRoute(
                navController = navController
            )
        }
        composable<Screens.Detail> { backStackEntry ->
            val movieId = backStackEntry.toRoute<Screens.Detail>().movieId
            MovieDetailScreenRoute(
                navController = navController,
                snackBarHostState = snackBarHostState,
                movieId = movieId,
            )
        }
        composable<Screens.PersonDetail> { backStackEntry ->
            val personId = backStackEntry.toRoute<Screens.PersonDetail>().personId
            PersonDetailScreenRoute(
                navController = navController,
                personId = personId,
            )
        }
        composable<Screens.Setting> {
            SettingScreenRoute(
                navController = navController,
                isLightTheme = isLightTheme,
                onSelectTheme = onSelectTheme
            )
        }
    }
}