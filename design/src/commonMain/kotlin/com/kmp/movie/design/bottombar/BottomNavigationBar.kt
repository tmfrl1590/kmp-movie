package com.kmp.movie.design.bottombar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.kmp.movie.core.presentation.Screens

val bottomDestinations: List<Screens> = listOf(
    Screens.Home,
    Screens.Setting,
)

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
){
    AppBottomNavigationBar(
        show = navController.shouldShowBottomBar,
        modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars)
    ) {
        bottomDestinations.forEach { screenItem ->
            AppBottomNavigationBarItem(
                icon = bottomIconSetting(screenItem),
                onTabClick = {
                    navController.navigate(screenItem) {
                        popUpTo(navController.graph.findStartDestination().route!!) {
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                },
            )
        }
    }
}

@Composable
fun AppBottomNavigationBar(
    modifier: Modifier = Modifier,
    show: Boolean,
    content: @Composable (RowScope.() -> Unit)
) {
    Surface(
        color = Color.Black,
        modifier = modifier
            .fillMaxWidth()
            .height(68.dp)
            .windowInsetsPadding(BottomAppBarDefaults.windowInsets)
    ) {
        if (show) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                    ,
                    color = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(85.dp)
                        .selectableGroup(),
                    verticalAlignment = Alignment.CenterVertically,
                    content = content
                )
            }
        }
    }
}

@Composable
fun RowScope.AppBottomNavigationBarItem(
    onTabClick: () -> Unit,
    icon: ImageVector,
) {
    Column(
        modifier = Modifier
            .weight(1f)
            .clickable(
                onClick = onTabClick,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "",
            modifier = Modifier
                .size(28.dp),
            tint = Color.White
        )
    }
}

private val NavController.shouldShowBottomBar
    get() = when (this.currentBackStackEntry.fromBottomRoute()) {
        Screens.Home,
        Screens.Setting,
            -> true

        else -> false
    }

@Composable
private fun bottomIconSetting(screens: Screens): ImageVector {
    return when(screens){
        Screens.Home -> Icons.Filled.Home
        Screens.Setting -> Icons.Filled.Settings
        else -> { Icons.Filled.Home }
    }
}

fun NavBackStackEntry?.fromBottomRoute(): Screens? {
    this?.destination?.route?.substringBefore("?")?.substringBefore("/")?.substringAfterLast(".")?.let {
        return when (it) {
            Screens.Home::class.simpleName -> Screens.Home
            Screens.Setting::class.simpleName -> Screens.Setting
            else -> null
        }
    }
    return null
}