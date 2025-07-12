package com.kmp.movie.design.error

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import com.kmp.movie.core.Resources
import org.jetbrains.compose.resources.painterResource

@Composable
fun ErrorLoadingPerson(){
    Box(
        modifier = Modifier
            .fillMaxSize()
        ,
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(Resources.Image.person),
            contentDescription = "default image",
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary,)
        )
    }
}