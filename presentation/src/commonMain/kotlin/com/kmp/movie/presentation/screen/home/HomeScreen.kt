package com.kmp.movie.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kmp.movie.presentation.BackHandlerUtil
import com.kmp.movie.presentation.ShowToastMessage
import com.kmp.movie.presentation.screen.home.action.HomeAction
import com.kmp.movie.presentation.screen.home.component.HomeBottomSheet
import com.kmp.movie.presentation.screen.home.component.HomeMovieListArea
import com.kmp.movie.presentation.screen.home.state.HomeState
import com.kmp.movie.presentation.screen.home.viewmodel.HomeViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

private const val EXIT_CONFIRMATION_MESSAGE = "한 번 더 누르면 종료됩니다"

@Composable
fun HomeScreenRoute(
    homeViewModel: HomeViewModel,
    homeState: HomeState,
    onClickMovie: (Int) -> Unit,
    onFinishApp: () -> Unit,
){
    val lazyGridState = rememberLazyGridState()

    var backPressedOnce by remember { mutableStateOf(false) }
    var showToastMessage by remember { mutableStateOf<String?>(null) }
    val coroutineScope = rememberCoroutineScope()

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

    // 토스트 메시지가 있을 때 표시
    showToastMessage?.let { message ->
        ShowToastMessage(message = message)
        LaunchedEffect(message) {
            showToastMessage = null
        }
    }

    BackHandlerUtil(enabled = true) {
        if (backPressedOnce) { 
            onFinishApp()
        } else {
            backPressedOnce = true
            showToastMessage = EXIT_CONFIRMATION_MESSAGE

            coroutineScope.launch {
                delay(2000)
                backPressedOnce = false
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