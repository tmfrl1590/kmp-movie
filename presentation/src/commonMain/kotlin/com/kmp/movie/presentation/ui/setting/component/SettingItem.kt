package com.kmp.movie.presentation.ui.setting.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kmp.movie.core.Resources
import org.jetbrains.compose.resources.stringResource

@Composable
fun SettingItem(
    title: String,
    isLightTheme: Boolean,
    onClick: () -> Unit,
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = title,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = if(isLightTheme) stringResource(Resources.String.light_theme) else stringResource(Resources.String.dark_theme),
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .clickable { onClick() }
        )
    }
}