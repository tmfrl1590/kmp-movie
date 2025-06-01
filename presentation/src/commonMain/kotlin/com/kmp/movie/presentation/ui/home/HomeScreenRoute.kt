package com.kmp.movie.presentation.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.kmp.movie.design.MovieListItem
import com.kmp.movie.presentation.ui.home.action.HomeAction
import com.kmp.movie.presentation.ui.home.component.ChoiceMovieBottomSheet
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
        onAction = { action ->
            homeViewModel.onAction(action = action)
        }
    )
}

@Composable
private fun HomeScreen(
    homeState: HomeState,
    gridState: LazyGridState,
    onAction: (HomeAction) -> Unit,
){
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            //.windowInsetsPadding(WindowInsets.safeDrawing)
        ,
        containerColor = Color.Black,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 16.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(vertical = 4.dp),
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Row (
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                    modifier = Modifier
                        .clickable {
                            onAction(HomeAction.OnShowBottomSheet(true))
                        }
                ){
                    Text(
                        text = homeState.selectedMovieType,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = Color.White
                    )
                    IconButton(
                        onClick = {
                            onAction(HomeAction.OnShowBottomSheet(true))
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowDown,
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier
                                .size(36.dp)
                        )
                    }

                }

                IconButton(
                    onClick = {},
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier
                            .size(40.dp)
                    )
                }
            }


            Spacer(modifier = Modifier.height(24.dp))

            if(homeState.selectedMovieType == "상영중인 영화"){
                LazyVerticalGrid(
                    modifier = Modifier
                        .weight(1f),
                    state = gridState,
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
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
            }else {
                LazyVerticalGrid(
                    modifier = Modifier
                        .weight(1f),
                    state = gridState,
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    itemsIndexed(
                        items = homeState.upComingMovieList,
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
    }

    if(homeState.isShowBottomSheet){
        ChoiceMovieBottomSheet(
            onBottomSheetClose = {
                onAction(HomeAction.OnShowBottomSheet(false))
            },
            onSelectMovie = { selectedMovieType ->
                onAction(HomeAction.OnSelectMovieType(selectedMovieType = selectedMovieType))
            }
        )
    }
}