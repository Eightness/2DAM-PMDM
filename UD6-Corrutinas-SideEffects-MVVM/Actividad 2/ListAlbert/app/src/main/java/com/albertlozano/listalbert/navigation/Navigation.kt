package com.albertlozano.listalbert.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.albertlozano.listalbert.ui.screens.MainScreen
import com.albertlozano.listalbert.ui.screens.VideogameInfo
import com.albertlozano.listalbert.viewmodel.VideogameViewModel

@Composable
fun Navigation(videogameViewMOdel: VideogameViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.MainScreen.route
    ) {
        composable(Routes.MainScreen.route) {
            MainScreen(navController, videogameViewMOdel)
        }
        composable(Routes.VideogameInfo.route) {
            VideogameInfo(navController, videogameViewMOdel)
        }
    }
}