package com.kmp.movie.presentation.ui.detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kmp.movie.design.AsyncImage
import com.kmp.movie.presentation.model.MovieCreditCastModel

@Composable
fun MovieCreditArea(
    movieCreditList: List<MovieCreditCastModel>
){
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = "출연진",
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
                .height(132.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(
                items = movieCreditList,
                key = { index, _ ->
                    index
                }
            ){ _, item ->
                MovieCreditItem(
                    profilePath = item.profilePath,
                    name = item.name,
                )
            }
        }
    }
}

@Composable
private fun MovieCreditItem(
    profilePath: String,
    name: String,
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ProfileImage(
            profilePath = profilePath
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        Text(
            text = name,
            fontSize = 12.sp,
            color = Color.White,
        )
    }
}

@Composable
private fun ProfileImage(
    profilePath: String,
){
    AsyncImage(
        modifier = Modifier
            .size(100.dp),
        urlString = profilePath,
        radius = 28.dp
    )
}