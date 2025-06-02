package com.kmp.movie.presentation.ui.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SelectMovieAndSearchArea(
    selectedMovieTypeText: String,
    onShowBottomSheet: (Boolean) -> Unit,
    onGotoSearch: () -> Unit,
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(vertical = 4.dp),
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row (
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
            modifier = Modifier
                .clickable {
                    onShowBottomSheet(true)
                }
        ){
            Text(
                text = selectedMovieTypeText,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.White
            )
            IconButton(
                onClick = {
                    onShowBottomSheet(true)
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = "select_movie",
                    tint = Color.White,
                    modifier = Modifier
                        .size(32.dp)
                )
            }

        }

        IconButton(
            onClick = onGotoSearch,
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "search",
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
            )
        }
    }
}