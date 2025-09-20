package com.kmp.movie.presentation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.kmp.movie.core.presentation.Screens
import com.kmp.movie.presentation.PresentationConstant.ANIMATION_DURATION
import com.kmp.movie.presentation.ui.detail.MovieDetailScreenRoute
import com.kmp.movie.presentation.ui.person_detail.PersonDetailScreenRoute
import com.kmp.movie.presentation.ui.search.SearchScreenRoute
import com.kmp.movie.presentation.ui.start.StartScreenRoute


@Composable
fun AppNavHost(
    isLightTheme: Boolean,
    onSelectTheme: (Boolean) -> Unit,
    onFinishApp: () -> Unit,
) {
    val navController = rememberNavController()
    val snackBarHostState = remember { SnackbarHostState() }

    NavHost(
        navController = navController,
        startDestination = Screens.Start,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
        ,
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(durationMillis = ANIMATION_DURATION)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(durationMillis = ANIMATION_DURATION)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(durationMillis = ANIMATION_DURATION)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(durationMillis = ANIMATION_DURATION)
            )
        }
    ){
        composable<Screens.Start>{
            StartScreenRoute(
                isLightTheme = isLightTheme,
                onSelectTheme = onSelectTheme,
                onGotoNavigateBack = {navController.popBackStack()},
                onGotoSearch = { navController.navigate(Screens.Search)},
                onClickMovie = { movieId -> navController.navigate(Screens.Detail(movieId) ) },
                onFinishApp = onFinishApp
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
                snackBarHostState = snackBarHostState,
                personId = personId,
            )
        }
    }
}