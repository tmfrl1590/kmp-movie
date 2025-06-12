package com.kmp.movie.presentation.ui.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kmp.movie.design.bottombar.BottomNavigationBar

@Composable
fun SettingScreenRoute(
    navController: NavHostController,
){
    SettingScreen(
        navController = navController,
    )
}

@Composable
private fun SettingScreen(
    navController: NavHostController,
){
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
        //.windowInsetsPadding(WindowInsets.safeDrawing)
        ,
        containerColor = Color.Black,
        bottomBar = {
            BottomNavigationBar(
                navController = navController
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 16.dp),
        ) {

        }
    }
}