package com.kmp.movie.presentation.ui.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SelectTab(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        SelectTabText(
            text = "상영중인 영화",
            textColor = Color.White
        )
        Spacer(modifier = Modifier.width(12.dp))
        SelectTabText(
            text = "개봉예정 영화",
            textColor = Color.White
        )
    }
}

@Composable
private fun SelectTabText(
    text: String,
    textColor: Color,
){
    Text(
        text = text,
        color = textColor,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    )
}