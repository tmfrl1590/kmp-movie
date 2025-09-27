package com.kmp.movie.presentation.screen.home.component

import androidx.compose.runtime.Composable
import com.kmp.movie.core.type.MovieType

@Composable
fun HomeBottomSheet(
    isVisible: Boolean,
    onBottomSheetClose: () -> Unit,
    onSelectMovie: (MovieType) -> Unit
) {
    if (isVisible) {
        ChoiceMovieTypeBottomSheet(
            onBottomSheetClose = onBottomSheetClose,
            onSelectMovie = onSelectMovie
        )
    }
}