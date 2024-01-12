package com.albertlozano.albertfinal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.albertlozano.albertfinal.ui.screens.AddScreen
import com.albertlozano.albertfinal.ui.screens.AuthorScreen
import com.albertlozano.albertfinal.ui.screens.EditScreen
import com.albertlozano.albertfinal.ui.screens.LogOutScreen
import com.albertlozano.albertfinal.ui.screens.MainScreen
import com.albertlozano.albertfinal.ui.screens.ProductInfo
import com.albertlozano.albertfinal.ui.screens.SplashScreen
import com.albertlozano.albertfinal.ui.screens.onboarding.FirstOnBoarding
import com.albertlozano.albertfinal.ui.screens.onboarding.FourthOnBoarding
import com.albertlozano.albertfinal.ui.screens.onboarding.SecondOnBoarding
import com.albertlozano.albertfinal.ui.screens.onboarding.ThirdOnBoarding
import com.albertlozano.albertfinal.viewmodel.ProductViewModel

@Composable
fun Navigation(productViewModel: ProductViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen.route
    ) {
        //Splash Screen
        composable(Routes.SplashScreen.route) {
            SplashScreen(navController)
        }

        //On Boarding
        composable(Routes.FirstOnBoarding.route) {
            FirstOnBoarding(navController, productViewModel)
        }
        composable(Routes.SecondOnBoarding.route) {
            SecondOnBoarding(navController, productViewModel)
        }
        composable(Routes.ThirdOnBoarding.route) {
            ThirdOnBoarding(navController, productViewModel)
        }
        composable(Routes.FourthOnBoarding.route) {
            FourthOnBoarding(navController, productViewModel)
        }

        //Main Screen
        composable(Routes.MainScreen.route) {
            MainScreen(navController, productViewModel)
        }
        composable(Routes.ProductInfo.route) {
            ProductInfo(navController, productViewModel)
        }

        //DropDown Menu
        composable(Routes.AddScreen.route) {
            AddScreen(navController, productViewModel)
        }
        composable(Routes.EditScreen.route) {
            EditScreen(navController, productViewModel)
        }
        composable(Routes.AuthorScreen.route) {
            AuthorScreen(navController, productViewModel)
        }
        composable(Routes.LogOutScreen.route) {
            LogOutScreen(navController, productViewModel)
        }
    }
}