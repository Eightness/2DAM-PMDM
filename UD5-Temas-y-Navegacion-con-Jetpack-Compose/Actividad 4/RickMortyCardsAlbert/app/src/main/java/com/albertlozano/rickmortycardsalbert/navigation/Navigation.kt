/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano.rickmortycardsalbert.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.albertlozano.rickmortycardsalbert.ui.screens.mainscreen.FirstScreen
import com.albertlozano.rickmortycardsalbert.ui.screens.mainscreen.SecondScreen
import com.albertlozano.rickmortycardsalbert.ui.screens.onboarding.FirstOnBoard
import com.albertlozano.rickmortycardsalbert.ui.screens.onboarding.FourthOnBoard
import com.albertlozano.rickmortycardsalbert.ui.screens.onboarding.SecondOnBoard
import com.albertlozano.rickmortycardsalbert.ui.screens.onboarding.ThirdOnBoard
import com.albertlozano.rickmortycardsalbert.ui.screens.splashscreen.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen.route,
    ) {
        composable(Routes.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Routes.FirstScreen.route) {
            FirstScreen(navController = navController)
        }
        composable(Routes.SecondScreen.route) {
            SecondScreen(navController = navController)
        }
        composable(Routes.FirstOnBoard.route) {
            FirstOnBoard(navController = navController)
        }
        composable(Routes.SecondOnBoard.route) {
            SecondOnBoard(navController = navController)
        }
        composable(Routes.ThirdOnBoard.route) {
            ThirdOnBoard(navController = navController)
        }
        composable(Routes.FourthOnBoard.route) {
            FourthOnBoard(navController = navController)
        }
    }
}
