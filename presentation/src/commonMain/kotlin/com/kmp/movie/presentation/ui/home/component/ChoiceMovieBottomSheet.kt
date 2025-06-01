package com.kmp.movie.presentation.ui.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kmp.movie.presentation.type.MovieType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChoiceMovieTypeBottomSheet(
    onBottomSheetClose: () -> Unit,
    onSelectMovie: (MovieType) -> Unit,
){
    val sheetState = rememberStandardBottomSheetState(
        initialValue = SheetValue.Expanded,
        skipHiddenState = false
    )

    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = {
            onBottomSheetClose()
        },
        containerColor = White,
        dragHandle = null,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 20.dp)
        ) {
            BottomSheetTitleArea(
                titleText = "영화타입을 선택해주세요",
                onSheetClose = onBottomSheetClose,
            )

            MovieTypeItem(
                movieTypeText = MovieType.NOW_PLAYING.displayName,
                onClick = { onSelectMovie(MovieType.NOW_PLAYING) },
            )

            MovieTypeItem(
                movieTypeText = MovieType.UPCOMING.displayName,
                onClick = { onSelectMovie(MovieType.UPCOMING) },
            )
        }
    }
}


@Composable
fun BottomSheetTitleArea(
    titleText: String,
    onSheetClose: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = titleText,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
        )

        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "close",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 16.dp)
                .size(24.dp)
                .clickable { onSheetClose() }
        )
    }
}

@Composable
fun MovieTypeItem(
    movieTypeText: String,
    onClick: () -> Unit,
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.CenterStart
    ){
        Text(
            text = movieTypeText,
            fontSize = 16.sp,
        )
    }
}