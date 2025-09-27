package com.kmp.movie.presentation.screen.setting.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kmp.movie.core.Resources
import com.kmp.movie.presentation.getAppVersion
import org.jetbrains.compose.resources.stringResource

@Composable
fun AppVersionArea(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = stringResource(Resources.String.app_version),
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = getAppVersion(),
            color = MaterialTheme.colorScheme.primary
        )
    }
}