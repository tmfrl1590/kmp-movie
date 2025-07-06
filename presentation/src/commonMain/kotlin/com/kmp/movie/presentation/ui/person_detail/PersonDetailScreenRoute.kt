package com.kmp.movie.presentation.ui.person_detail

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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.kmp.movie.core.presentation.Screens
import com.kmp.movie.design.error.toMessage
import com.kmp.movie.design.loading.LoadingBar
import com.kmp.movie.design.topbar.CenterTopBar
import com.kmp.movie.presentation.ui.person_detail.component.CombinedMovieListArea
import com.kmp.movie.presentation.ui.person_detail.component.PersonImage
import com.kmp.movie.presentation.ui.person_detail.component.PersonInfoArea
import com.kmp.movie.presentation.ui.person_detail.state.PersonDetailState
import com.kmp.movie.presentation.ui.person_detail.viewmodel.PersonDetailViewModel
import kotlinx.coroutines.flow.collectLatest
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun PersonDetailScreenRoute(
    navController: NavHostController,
    snackBarHostState: SnackbarHostState,
    personId: Int,
    viewModel: PersonDetailViewModel = koinViewModel(),
){
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = personId) {
        viewModel.getPersonDetailAndCombinedMovie(personId = personId)
    }

    LaunchedEffect(Unit) {
        viewModel.error.collectLatest { error ->
            snackBarHostState.showSnackbar(message = error.toMessage())
        }
    }

    PersonDetailScreen(
        snackBarHostState = snackBarHostState,
        state = state,
        onGotoNavigateBack = { navController.popBackStack() },
        onClickMovie = { movieId -> navController.navigate(Screens.Detail(movieId = movieId))},
    )
}

@Composable
private fun PersonDetailScreen(
    snackBarHostState: SnackbarHostState,
    state: PersonDetailState,
    onGotoNavigateBack: () -> Unit,
    onClickMovie: (Int) -> Unit,
){
    val scrollState = rememberScrollState()
    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
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
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        },
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        if(state.isLoading){
            LoadingBar()
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .verticalScroll(scrollState)
                ,
            ) {
                PersonImage(
                    imageUrl = state.personDetailInfo.profilePath
                )

                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )

                PersonInfoArea(
                    name = state.personDetailInfo.name,
                    birthDay = state.personDetailInfo.birthday,
                    gender = state.personDetailInfo.gender,
                    knownForDepartment = state.personDetailInfo.knownForDepartment
                )

                Spacer(
                    modifier = Modifier
                        .height(32.dp)
                )

                CombinedMovieListArea(
                    combinedMovieList = state.combinedMovieModel.cast,
                    onClickMovie = onClickMovie
                )
            }
        }
    }
}