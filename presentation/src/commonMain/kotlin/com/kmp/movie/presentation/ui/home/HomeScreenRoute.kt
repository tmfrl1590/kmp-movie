package com.kmp.movie.presentation.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.kmp.movie.core.presentation.Screens
import com.kmp.movie.core.type.MovieType
import com.kmp.movie.design.bottombar.BottomNavigationBar
import com.kmp.movie.presentation.ui.home.action.HomeAction
import com.kmp.movie.presentation.ui.home.component.HomeBottomSheet
import com.kmp.movie.presentation.ui.home.component.HomeMovieListArea
import com.kmp.movie.presentation.ui.home.component.SelectMovieAndSearchArea
import com.kmp.movie.presentation.ui.home.state.HomeState
import com.kmp.movie.presentation.ui.home.viewmodel.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreenRoute(
    navController: NavHostController,
    homeViewModel: HomeViewModel = koinViewModel(),
){
    val homeState by homeViewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(homeState.selectedMovieType) {
        when(homeState.selectedMovieType){
            MovieType.NOW_PLAYING -> homeViewModel.getNowPlayingMovieList()
            MovieType.UPCOMING -> homeViewModel.getUpComingMovieList()
            MovieType.POPULAR -> homeViewModel.getPopularMovieList()
        }
    }

    HomeBottomSheet(
        isVisible = homeState.isShowBottomSheet,
        onBottomSheetClose = { homeViewModel.onAction(HomeAction.OnShowBottomSheet(false)) },
        onSelectMovie = { selectedMovieType -> homeViewModel.onAction(HomeAction.OnSelectMovieType(selectedMovieType)) }
    )

    HomeScreen(
        navController = navController,
        homeState = homeState,
        onAction = { action ->
            homeViewModel.onAction(action = action)
        },
        onGotoSearch = { navController.navigate(Screens.Search)},
        onClickMovie = { movieId -> navController.navigate(Screens.Detail(movieId) ) }
    )
}

@Composable
private fun HomeScreen(
    navController: NavHostController,
    homeState: HomeState,
    onAction: (HomeAction) -> Unit,
    onGotoSearch: () -> Unit,
    onClickMovie: (Int) -> Unit,
){
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            //.windowInsetsPadding(WindowInsets.safeDrawing)
        ,
        containerColor = Color.Black,
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
            SelectMovieAndSearchArea(
                selectedMovieTypeText = homeState.selectedMovieType.displayName,
                onShowBottomSheet = {
                    onAction(HomeAction.OnShowBottomSheet(it))
                },
                onGotoSearch = onGotoSearch
            )

            Spacer(modifier = Modifier.height(24.dp))

            HomeMovieListArea(
                modifier = Modifier
                    .weight(1f),
                isLoading = homeState.isLoading,
                homeMovieList = homeState.homeMovieList,
                onClickMovie = onClickMovie
            )
        }
    }
}