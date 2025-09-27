package com.kmp.movie.presentation.screen.detail.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kmp.movie.design.topbar.CenterTopBar

@Composable
fun MovieDetailTopBar(
    onGotoNavigateBack: () -> Unit,
){
    CenterTopBar(
        title = {},
        navigationIcon = {
            IconButton(
                onClick = onGotoNavigateBack,
            ){
                Icon(
                    imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                    contentDescription = "back",
                    modifier = Modifier
                        .size(32.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    )
}