package com.kmp.movie.design.topbar

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterTopBar(
    title: @Composable (() -> Unit),
    navigationIcon: @Composable (() -> Unit),
){
    CenterAlignedTopAppBar(
        title = title,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        navigationIcon = navigationIcon,
    )
}