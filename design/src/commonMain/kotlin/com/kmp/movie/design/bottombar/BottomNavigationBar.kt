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
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.kmp.movie.core.presentation.BottomBarScreen
import com.kmp.movie.core.presentation.bottomDestinations

@Composable
fun BottomNavigationBar(
    currentScreen: BottomBarScreen,
    navController: NavHostController,
    onTabClick: (BottomBarScreen) -> Unit,
){
    AppBottomNavigationBar(
        show = navController.shouldShowBottomBar,
        modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars)
    ) {
        bottomDestinations.forEach { bottomBarScreen ->
            AppBottomNavigationBarItem(
                icon = bottomBarScreen.icon,
                onTabClick = { onTabClick(bottomBarScreen) },
                isSelected = currentScreen == bottomBarScreen,
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
        color = MaterialTheme.colorScheme.background,
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
    isSelected: Boolean,
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
            tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )
    }
}

fun NavBackStackEntry?.fromBottomRoute(): BottomBarScreen {
    this?.destination?.route?.substringBefore("?")?.substringBefore("/")?.substringAfterLast(".")?.let {
        return when (it) {
            BottomBarScreen.Home::class.simpleName -> BottomBarScreen.Home
            BottomBarScreen.Setting::class.simpleName -> BottomBarScreen.Setting
            else -> BottomBarScreen.Home
        }
    }
    return BottomBarScreen.Home
}

private val NavController.shouldShowBottomBar
    get() = when (this.currentBackStackEntry.fromBottomRoute()) {
        BottomBarScreen.Home,
        BottomBarScreen.Setting,
            -> true
    }