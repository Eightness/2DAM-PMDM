/**
 * @author Albert Lozano Blasco
 * @version 2.1
 */

package com.albertlozano.albertfinal.navigation

/**
 * Routes Sealed Class
 *
 * @property routes
 */
sealed class Routes(val routes: String) {
    data object SplashScreen : Routes("splash_screen")
    data object MainScreen : Routes("main_screen")
    data object OnBoardingScreen : Routes("onboarding_screen")
    data object AuthorScreen : Routes("author_screen")
    data object ProductScreen : Routes("product_screen")
    data object AddScreen : Routes("add_screen")
    data object EditScreen : Routes("edit_screen")
}