package com.kmp.movie.presentation.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.kmp.movie.presentation.ui.home.state.HomeState
import com.kmp.movie.presentation.ui.home.viewmodel.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreenRoute(
    navController: NavHostController,
    homeViewModel: HomeViewModel = koinViewModel(),
){
    val homeState by homeViewModel.state.collectAsStateWithLifecycle()

    HomeScreen(
        homeState = homeState,
    )
}

@Composable
private fun HomeScreen(
    homeState: HomeState,
){

}