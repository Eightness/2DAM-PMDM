/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano.rickmortycardsalbert.navigation

sealed class Routes(val route: String) {
    object SplashScreen: Routes("splash_screen")
    object FirstScreen: Routes("first_screen")
    object SecondScreen: Routes("second_screen")
    object FirstOnBoard: Routes("first_onBoard")
    object SecondOnBoard: Routes("second_onBoard")
    object ThirdOnBoard: Routes("third_onBoard")
    object FourthOnBoard: Routes("fourth_onBoard")
}