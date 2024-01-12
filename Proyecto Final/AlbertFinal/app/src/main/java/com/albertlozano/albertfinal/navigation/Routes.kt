package com.albertlozano.albertfinal.navigation

sealed class Routes(val route: String){
    object SplashScreen: Routes("splashscreen")
    object FirstOnBoarding: Routes("firstonboarding")
    object SecondOnBoarding: Routes("secondonboarding")
    object ThirdOnBoarding: Routes("thirdonboarding")
    object FourthOnBoarding: Routes("fourthonboarding")
    object MainScreen: Routes("mainscreen")
    object ProductInfo: Routes("productinfoscreen")
    object AddScreen: Routes("addscreen")
    object EditScreen: Routes("editscreen")
    object AuthorScreen: Routes("authorscreen")
    object LogOutScreen: Routes("logoutscreen")
}
