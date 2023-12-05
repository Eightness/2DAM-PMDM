package com.albertlozano.listalbert.navigation

sealed class Routes(val route: String){
    object MainScreen: Routes("main_screen")
    object VideogameInfo: Routes("videogame_info_screen")
}
