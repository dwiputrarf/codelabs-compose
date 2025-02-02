package com.kodekita.codelabs.ui.view.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.kodekita.codelabs.ui.theme.neutral70
import com.kodekita.codelabs.ui.theme.primaryLight

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Explore,
        BottomNavItem.Orders,
        BottomNavItem.History,
        BottomNavItem.Account
    )

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination

    Column {
        Divider(color = Color.LightGray)
        NavigationBar(
            containerColor = Color.White,
            contentColor = primaryLight,
            tonalElevation = 4.dp
        ) {
            items.forEach { item ->
                val selected = currentDestination?.route == item.route
                NavigationBarItem(
                    icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                    label = { Text(text = item.label) },
                    selected = selected,
                    onClick = {
                        navController.navigate(item.route) {
                            // Avoid multiple copies of the same destination
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                            // Pop up to the start destination of the graph to avoid building up a large stack of destinations
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = primaryLight,
                        unselectedIconColor = neutral70,
                        selectedTextColor = primaryLight,
                        unselectedTextColor = neutral70,
                        indicatorColor = Color.White
                    )
                )
            }
        }
    }
}

sealed class BottomNavItem(val icon: androidx.compose.ui.graphics.vector.ImageVector, val label: String, val route: String) {
    object Explore : BottomNavItem(Icons.Filled.Explore, "Explore", "home")
    object Orders : BottomNavItem(Icons.Filled.List, "Pesanan", "pesanan")
    object History : BottomNavItem(Icons.Filled.History, "Riwayat", "history")
    object Account : BottomNavItem(Icons.Filled.Person, "Akun", "account")
}