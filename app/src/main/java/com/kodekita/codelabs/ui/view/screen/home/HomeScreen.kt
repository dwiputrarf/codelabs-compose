package com.kodekita.codelabs.ui.view.screen.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kodekita.codelabs.ui.view.component.BottomNavigationBar
import com.kodekita.codelabs.ui.view.screen.login.LoginScreen

@Composable
fun HomeScreen(navController: NavHostController) {
    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(bottomNavController)
        }
    ) { innerPadding ->
        NavHost(
            navController = bottomNavController,
            startDestination = "login_screen",
            Modifier.padding(innerPadding)
        ) {
            composable("login_screen") { LoginScreen(navController) }
//            if (isLoggedIn) {
//                composable("pesanan") { OrdersScreen(navController) }
//                composable("history") { TransactionHistoryScreen(navController) }
//                composable("account") { AccountScreen(navController, viewModel) }
//            } else {
//                composable("pesanan") { RedirectToLogin(navController) }
//                composable("history") { RedirectToLogin(navController) }
//                composable("account") { RedirectToLogin(navController) }
//            }
            composable("login_screen") { LoginScreen(navController) }
        }
    }
}