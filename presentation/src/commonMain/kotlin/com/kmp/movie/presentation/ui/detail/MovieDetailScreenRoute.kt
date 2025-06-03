package com.kmp.movie.presentation.ui.detail

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
import com.kmp.movie.presentation.ui.detail.component.MovieImage
import com.kmp.movie.presentation.ui.detail.component.MovieInfoArea
import com.kmp.movie.presentation.ui.detail.state.MovieDetailState
import com.kmp.movie.presentation.ui.detail.viewmodel.MovieDetailViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MovieDetailScreenRoute(
    navController: NavHostController,
    movieId: Int,
    movieDetailMovieModel: MovieDetailViewModel = koinViewModel()
){
    val state by movieDetailMovieModel.state.collectAsStateWithLifecycle()

    LaunchedEffect( key1 = movieId) {
        movieDetailMovieModel.getMovieDetail(movieId = movieId)
    }

    MovieDetailScreen(
        state = state,
    )
}

@Composable
private fun MovieDetailScreen(
    state: MovieDetailState,
){
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
        ,
        containerColor = Color.Black,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
            ,
        ) {
            MovieImage(
                imageUrl = state.movieDeDetailInfo.backdropPath
            )

            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
            MovieInfoArea(
                title = state.movieDeDetailInfo.title,
                releaseDate = state.movieDeDetailInfo.releaseDate,
                runTime = state.movieDeDetailInfo.runtime,
                voteAverage = state.movieDeDetailInfo.voteAverage.toString(),
                voteCount = state.movieDeDetailInfo.voteCount,
                genreList = state.movieDeDetailInfo.genres,
                overview = state.movieDeDetailInfo.overview,
            )
        }
    }
}