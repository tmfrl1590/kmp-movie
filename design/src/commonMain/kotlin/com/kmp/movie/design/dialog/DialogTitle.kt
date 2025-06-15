package com.kmp.movie.design.dialog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DialogTitle(
    dialogTitle: String,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp)
        ,
        contentAlignment = Alignment.Center
    ){
        Text(
            text = dialogTitle,
            fontSize = 18.sp,
        )
    }

}