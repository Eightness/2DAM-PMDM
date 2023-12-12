/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano.workoutalbert.navigation

sealed class Routes (val route: String) {
    object MainScreen: Routes("main_screen")
    object SecondScreen: Routes("second_screen")
}