/**
 * @author Albert Lozano Blasco
 * @version 2.1
 */

package com.albertlozano.albertfinal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.albertlozano.albertfinal.ui.screens.AddScreen
import com.albertlozano.albertfinal.ui.screens.AuthorScreen
import com.albertlozano.albertfinal.ui.screens.EditScreen
import com.albertlozano.albertfinal.ui.screens.MainScreen
import com.albertlozano.albertfinal.ui.screens.OnBoardingScreen
import com.albertlozano.albertfinal.ui.screens.ProductScreen
import com.albertlozano.albertfinal.ui.screens.SplashScreen
import com.albertlozano.albertfinal.viewmodel.MainScreenViewModel

/**
 * Navigation Composable
 *
 * @param mainScreenViewModel
 */
@Composable
fun Navigation(mainScreenViewModel: MainScreenViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen.routes
    ) {
        composable(
            route = Routes.SplashScreen.routes
        ) {
            SplashScreen(navController, mainScreenViewModel)
        }
        composable(
            route = Routes.MainScreen.routes
        ) {
            MainScreen(navController, mainScreenViewModel)
        }
        composable(
            route = Routes.OnBoardingScreen.routes
        ) {
            OnBoardingScreen(navController, mainScreenViewModel)
        }
        composable(
            route = Routes.AuthorScreen.routes
        ) {
            AuthorScreen(navController)
        }
        composable(
            route = Routes.AddScreen.routes
        ) {
            AddScreen(navController, mainScreenViewModel)
        }
        composable(
            route = Routes.ProductScreen.routes
        ) {
            ProductScreen(navController, mainScreenViewModel)
        }
        composable(
            route = Routes.EditScreen.routes
        ) {
            EditScreen(navController, mainScreenViewModel)
        }
    }
}