package com.kmp.movie.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kmp.movie.presentation.ui.home.action.HomeAction
import com.kmp.movie.presentation.ui.home.component.HomeBottomSheet
import com.kmp.movie.presentation.ui.home.component.HomeMovieListArea
import com.kmp.movie.presentation.ui.home.state.HomeState
import com.kmp.movie.presentation.ui.home.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged

@Composable
fun HomeScreenRoute(
    homeViewModel: HomeViewModel,
    homeState: HomeState,
    onClickMovie: (Int) -> Unit,
){
    val lazyGridState = rememberLazyGridState()

    LaunchedEffect(Unit) {
        homeViewModel.scrollToTop.collectLatest {
            lazyGridState.scrollToItem(0)
        }
    }

    HomeBottomSheet(
        isVisible = homeState.isShowBottomSheet,
        onBottomSheetClose = { homeViewModel.onAction(HomeAction.OnShowBottomSheet(false)) },
        onSelectMovie = { selectedMovieType -> homeViewModel.onAction(HomeAction.OnSelectMovieType(selectedMovieType)) }
    )

    LaunchedEffect(key1 = homeState.homeMovieList){
        snapshotFlow {
            lazyGridState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
        }
            .distinctUntilChanged()
            .collect { lastVisibleIndex ->
                if(lastVisibleIndex == homeState.homeMovieList.lastIndex) {
                    homeViewModel.loadMovieList()
                }
            }
    }

    HomeScreen(
        lazyGridState = lazyGridState,
        homeState = homeState,
        onClickMovie = onClickMovie
    )
}

@Composable
private fun HomeScreen(
    lazyGridState: LazyGridState,
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
            lazyGridState = lazyGridState,
            isLoading = homeState.isLoading,
            homeMovieList = homeState.homeMovieList,
            onClickMovie = onClickMovie
        )
    }
}