package com.piyushprajpti.pychat.presentation.home

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.piyushprajpti.pychat.ui.theme.Typography

data class BottomNavigationItem(
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeCount: Int? = null
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {

    var selectedIndex by remember {
        mutableIntStateOf(1)
    }

    val iconsList = listOf(
        BottomNavigationItem(
            label = "Users",
            selectedIcon = Icons.Filled.AccountBox,
            unselectedIcon = Icons.Outlined.AccountBox
        ),
        BottomNavigationItem(
            label = "Chats",
            selectedIcon = Icons.Filled.ChatBubble,
            unselectedIcon = Icons.Outlined.ChatBubbleOutline,
            badgeCount = 1
        ),
        BottomNavigationItem(
            label = "Settings",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings
        )
    )

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.background
            ) {
                iconsList.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedIndex == index,

                        label = { Text(text = item.label, style = Typography.labelSmall) },

                        onClick = { selectedIndex = index },

                        icon = {
                            BadgedBox(
                                badge = {
                                    if (item.badgeCount != null && item.badgeCount > 0) {
                                        Badge {
                                            Text(
                                                text = item.badgeCount.toString(),
                                                style = Typography.labelSmall
                                            )
                                        }
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = if (selectedIndex == index) item.selectedIcon else item.unselectedIcon,
                                    contentDescription = item.label
                                )
                            }
                        },

                        colors = NavigationBarItemColors(
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            unselectedIconColor = MaterialTheme.colorScheme.secondary,
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                            unselectedTextColor = MaterialTheme.colorScheme.secondary,
                            selectedIndicatorColor = Color.Transparent,
                            disabledTextColor = Color.Transparent,
                            disabledIconColor = Color.Transparent
                        )
                    )
                }
            }
        },

        content = {
            when (selectedIndex) {
                0 -> {
                    UsersScreen()
                }

                1 -> {
                    AllChatsScreen()
                }

                2 -> {
                    SettingsScreen()
                }
            }
        }
    )
}