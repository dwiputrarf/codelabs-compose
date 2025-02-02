package com.kodekita.codelabs.utils

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kodekita.codelabs.ui.view.screen.home.HomeScreen
import com.kodekita.codelabs.ui.viewmodel.UserViewModel

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun Navigation(navController: NavHostController) {
    val profileViewModel: UserViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Route.HOME_SCREEN
    ) {
        composable(Route.HOME_SCREEN) {
            HomeScreen(navController = navController)
        }
    }
}