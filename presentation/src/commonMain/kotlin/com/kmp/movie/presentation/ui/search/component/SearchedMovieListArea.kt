package com.kmp.movie.presentation.ui.search.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kmp.movie.core.Resources
import com.kmp.movie.presentation.model.SearchedMovieDataModel
import org.jetbrains.compose.resources.stringResource

@Composable
fun SearchedMovieListArea(
    modifier: Modifier,
    movieList: List<SearchedMovieDataModel>,
    onClickMovie: (Int) -> Unit,
){
    val gridState = rememberLazyGridState()

    if(movieList.isEmpty()){
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = stringResource(Resources.String.noMovie),
                color = MaterialTheme.colorScheme.primary,
                fontSize = 20.sp
            )
        }
    }else {
        LazyVerticalGrid(
            modifier = modifier,
            state = gridState,
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            itemsIndexed(
                items = movieList,
                key = { index, _ ->
                    index
                }
            ) { _, item ->
                SearchedMovieListItem(
                    modifier = Modifier,
                    urlString = item.posterPath,
                    title = item.title,
                    voteAverage = item.voteAverage,
                    voteCount = item.voteCount,
                    onClickMovie = {
                        onClickMovie(item.id)
                    }
                )
            }
        }
    }

}