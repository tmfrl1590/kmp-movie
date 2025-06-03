package com.kmp.movie.presentation.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.kmp.movie.design.topbar.CenterTopBar
import com.kmp.movie.presentation.ui.detail.component.MovieCreditArea
import com.kmp.movie.presentation.ui.detail.component.MovieImage
import com.kmp.movie.presentation.ui.detail.component.MovieInfoArea
import com.kmp.movie.presentation.ui.detail.component.SimilarMovieListArea
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
        movieDetailMovieModel.getMovieCredit(movieId = movieId)
        movieDetailMovieModel.getSimilarMovie(movieId = movieId)
    }

    MovieDetailScreen(
        state = state,
        onGotoNavigateBack = { navController.popBackStack() },
        onClickMovie = { navController.navigate(Screens.Detail(it))}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MovieDetailScreen(
    state: MovieDetailState,
    onGotoNavigateBack: () -> Unit,
    onClickMovie: (Int) -> Unit,
){
    val scrollState = rememberScrollState()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
        ,
        topBar = {
            CenterTopBar(
                title = {},
                navigationIcon = {
                    IconButton(
                        onClick = onGotoNavigateBack,
                    ){
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "back",
                            modifier = Modifier
                                .size(32.dp),
                            tint = Color.White
                        )
                    }
                }
            )
        },
        containerColor = Color.Black,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(scrollState)
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

            Spacer(
                modifier = Modifier
                    .height(32.dp)
            )

            MovieCreditArea(
                movieCreditList = state.movieCredit.cast
            )

            Spacer(
                modifier = Modifier
                    .height(32.dp)
            )

            SimilarMovieListArea(
                similarMovieList = state.similarMovie.results,
                onClickMovie = onClickMovie,
            )

            Spacer(
                modifier = Modifier
                    .height(32.dp)
            )
        }
    }
}