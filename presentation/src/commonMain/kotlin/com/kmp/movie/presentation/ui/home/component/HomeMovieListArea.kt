package com.kmp.movie.presentation.ui.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kmp.movie.design.MovieListItem
import com.kmp.movie.presentation.model.HomeMovieModel

@Composable
fun HomeMovieListArea(
    modifier: Modifier,
    homeMovieList: List<HomeMovieModel>,
){
    val gridState = rememberLazyGridState()

    LazyVerticalGrid(
        modifier = modifier,
        state = gridState,
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