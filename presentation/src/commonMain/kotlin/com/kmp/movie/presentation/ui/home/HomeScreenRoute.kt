package com.kmp.movie.presentation.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.kmp.movie.design.MovieListItem
import com.kmp.movie.presentation.ui.home.state.HomeState
import com.kmp.movie.presentation.ui.home.viewmodel.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreenRoute(
    navController: NavHostController,
    homeViewModel: HomeViewModel = koinViewModel(),
){
    val homeState by homeViewModel.state.collectAsStateWithLifecycle()
    val gridState = rememberLazyGridState()

    HomeScreen(
        homeState = homeState,
        gridState = gridState,
    )
}

@Composable
private fun HomeScreen(
    homeState: HomeState,
    gridState: LazyGridState,
){
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
        ,
        containerColor = Color.Black,
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .padding(it)
                .padding(12.dp),
            state = gridState,
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            itemsIndexed(
                items = homeState.nowPlayingMovieList,
                key = { index, _ ->
                    index
                }
            ){_, item ->
                MovieListItem(
                    modifier = Modifier,
                    urlString = item.posterPath,
                    title = item.title,
                    voteAverage = item.voteAverage,
                    voteCount = item.voteCount
                )
            }
        }
    }
}