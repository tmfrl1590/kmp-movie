package com.kmp.movie.presentation.ui.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.kmp.movie.core.presentation.Screens
import com.kmp.movie.presentation.ui.search.action.SearchAction
import com.kmp.movie.presentation.ui.search.component.SearchInputArea
import com.kmp.movie.presentation.ui.search.component.SearchedMovieListArea
import com.kmp.movie.presentation.ui.search.state.SearchState
import com.kmp.movie.presentation.ui.search.viewmodel.SearchViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SearchScreenRoute(
    navController: NavHostController,
    searchViewModel: SearchViewModel = koinViewModel(),
){
    val searchState by searchViewModel.state.collectAsStateWithLifecycle()

    SearchScreen(
        searchState = searchState,
        onAction = { action ->
            searchViewModel.onAction(action = action)
        },
        onClickMovie = { navController.navigate(Screens.Detail(it))},
    )
}

@Composable
private fun SearchScreen(
    searchState: SearchState,
    onAction: (SearchAction) -> Unit,
    onClickMovie: (Int) -> Unit,
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
                .padding(horizontal = 16.dp),
        ) {
            SearchInputArea(
                inputText = searchState.inputText,
                onValueChange = { inputText -> onAction(SearchAction.OnInputText(inputText = inputText)) },
                onSearch = { onAction(SearchAction.OnSearch)},
                onResetInputText = { onAction(SearchAction.OnInputText(inputText = "")) }
            )

            Spacer(modifier = Modifier.height(24.dp))

            SearchedMovieListArea(
                modifier = Modifier
                    .weight(1f),
                movieList = searchState.searchedMovieList,
                onClickMovie = onClickMovie,
            )
        }
    }
}