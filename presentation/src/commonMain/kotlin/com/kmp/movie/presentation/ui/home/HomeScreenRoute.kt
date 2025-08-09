package com.kmp.movie.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kmp.movie.core.type.MovieType
import com.kmp.movie.presentation.ui.home.action.HomeAction
import com.kmp.movie.presentation.ui.home.component.HomeBottomSheet
import com.kmp.movie.presentation.ui.home.component.HomeMovieListArea
import com.kmp.movie.presentation.ui.home.state.HomeState
import com.kmp.movie.presentation.ui.home.viewmodel.HomeViewModel

@Composable
fun HomeScreenRoute(
    homeViewModel: HomeViewModel,
    homeState: HomeState,
    onClickMovie: (Int) -> Unit,
){
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
        homeState = homeState,
        onClickMovie = onClickMovie
    )
}

@Composable
private fun HomeScreen(
    homeState: HomeState,
    onClickMovie: (Int) -> Unit,
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .background(color = MaterialTheme.colorScheme.background)
        ,
    ) {
        HomeMovieListArea(
            modifier = Modifier
                .weight(1f),
            isLoading = homeState.isLoading,
            homeMovieList = homeState.homeMovieList,
            onClickMovie = onClickMovie
        )
    }
}