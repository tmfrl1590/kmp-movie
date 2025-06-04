package com.kmp.movie.presentation.ui.detail.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kmp.movie.design.HomeMovieListItem
import com.kmp.movie.presentation.model.RecommendMovieDataModel

@Composable
fun RecommendMovieListArea(
    recommendMovieList: List<RecommendMovieDataModel>,
    onClickMovie: (Int) -> Unit,
){
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = "추천 영화",
            fontSize = 20.sp,
            color = Color.White,
        )
        Spacer(
            modifier = Modifier
                .height(12.dp)
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
            ,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(
                items = recommendMovieList,
                key = { index, _ ->
                    index
                }
            ) { _, item ->
                HomeMovieListItem(
                    modifier = Modifier
                        .width(120.dp)
                        .clickable {
                            onClickMovie(item.id)
                        },
                    asyncImageModifier = Modifier
                        .width(120.dp)
                        .height(180.dp)
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