package com.kmp.movie.presentation.ui.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kmp.movie.design.HomeMovieListItem
import com.kmp.movie.design.loading.LoadingBar
import com.kmp.movie.presentation.model.HomeMovieModel

@Composable
fun HomeMovieListArea(
    modifier: Modifier,
    lazyGridState: LazyGridState,
    isLoading: Boolean,
    homeMovieList: List<HomeMovieModel>,
    onClickMovie: (Int) -> Unit,
){
    if(isLoading){
        LoadingBar()
    } else {
        LazyVerticalGrid(
            state = lazyGridState,
            modifier = modifier,
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            itemsIndexed(
                items = homeMovieList,
                key = { index, _ ->
                    index
                }
            ){_, item ->
                HomeMovieListItem(
                    modifier = Modifier
                        .clickable {
                            onClickMovie(item.id)
                        },
                    asyncImageModifier = Modifier
                        .height(240.dp)
                        .padding(bottom = 8.dp),
                    urlString = item.posterPath,
                    title = item.title,
                    voteAverage = item.voteAverage,
                    voteCount = item.voteCount
                )
            }
        }
    }
}