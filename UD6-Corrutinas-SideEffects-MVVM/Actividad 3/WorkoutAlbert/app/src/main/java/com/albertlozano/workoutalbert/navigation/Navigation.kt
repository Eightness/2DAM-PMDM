/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano.workoutalbert.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.albertlozano.workoutalbert.ui.screens.MainScreen
import com.albertlozano.workoutalbert.ui.screens.SecondScreen
import com.albertlozano.workoutalbert.viewmodel.WorkoutViewModel

@Composable
fun Navigation(workoutViewModel: WorkoutViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.MainScreen.route
    ) {
        composable(Routes.MainScreen.route) {
            MainScreen(navController, workoutViewModel)
        }
        composable(Routes.SecondScreen.route) {
            SecondScreen(navController, workoutViewModel)
        }
    }
}