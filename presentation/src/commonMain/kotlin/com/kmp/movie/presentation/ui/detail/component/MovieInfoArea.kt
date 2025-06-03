package com.kmp.movie.presentation.ui.detail.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MovieInfoArea(
    title: String,
    releaseDate: String,
    runTime: String,
    voteAverage: String,
    voteCount: Int,
    genreList: List<String>,
    overview: String,
){
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
    ){
        MovieTitle(
            title = title,
        )

        Spacer(
            modifier = Modifier
                .height(8.dp)
        )

        GenreList(
            genreList = genreList,
        )

        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        MovieReleaseDateAndRunTime(
            releaseDate = releaseDate,
            runTime = runTime,
        )

        Spacer(
            modifier = Modifier
                .height(8.dp)
        )

        MovieVoteAverage(
            voteAverage = voteAverage,
            voteCount = voteCount,
        )

        Spacer(
            modifier = Modifier
                .height(8.dp)
        )

        MovieOverView(
            overview = overview,
        )
    }

}

@Composable
private fun MovieTitle(
    title: String,
){
    Text(
        text = title,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = Color.White
    )
}

@Composable
private fun GenreList(
    genreList: List<String>,
){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        genreList.forEach {
            GenreCard(
                genreText = it,
            )
            Spacer(
                modifier = Modifier
                    .width(12.dp)
            )
        }
    }
}

@Composable
private fun GenreCard(
    genreText: String,
){
    Card(
        modifier = Modifier
            .wrapContentWidth()
            .height(32.dp)
        ,
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(999.dp)
    ) {
        Box(
            modifier = Modifier
                .wrapContentWidth()
                .fillMaxHeight()
                .padding(horizontal = 8.dp, vertical = 4.dp),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = genreText,
            )
        }
    }
}

@Composable
private fun MovieReleaseDateAndRunTime(
    releaseDate: String,
    runTime: String,
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = releaseDate,
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier
                .alignByBaseline()
        )
        Spacer(
            modifier = Modifier
                .width(8.dp)
        )
        Text(
            text = runTime,
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier
                .alignByBaseline()
        )
    }
}

@Composable
private fun MovieVoteAverage(
    voteAverage: String,
    voteCount: Int,
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = voteAverage,
            fontSize = 16.sp,
            color = Color.Yellow,
        )
        Icon(
            modifier = Modifier.size(16.dp),
            imageVector = Icons.Filled.Star,
            contentDescription = "",
            tint = Color.Yellow
        )
        Text(
            text = "($voteCount)",
            fontSize = 16.sp,
            color = Color.White
        )
    }
}

@Composable
fun MovieOverView(
    overview: String,
){
    Text(
        text = overview,
        fontSize = 16.sp,
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
    )
}
