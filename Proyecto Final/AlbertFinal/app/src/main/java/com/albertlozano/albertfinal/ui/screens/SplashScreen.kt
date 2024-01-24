/**
 * @author Albert Lozano Blasco
 * @version 2.1
 */

package com.albertlozano.albertfinal.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.albertlozano.albertfinal.R
import com.albertlozano.albertfinal.navigation.Routes
import com.albertlozano.albertfinal.viewmodel.MainScreenViewModel
import kotlinx.coroutines.delay

/**
 * SplashScreen Composable
 *
 * @param navController
 * @param mainScreenViewModel
 */
@Composable
fun SplashScreen(navController: NavHostController, mainScreenViewModel: MainScreenViewModel) {
    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.popBackStack()
        navController.navigate(Routes.MainScreen.routes)
        mainScreenViewModel.isDataStored(
            onCollected = {
                if (it) {
                    navController.navigate(Routes.MainScreen.routes)
                } else {
                    navController.navigate(Routes.OnBoardingScreen.routes)
                }
            }
        )
    }

    Splash()
}

/**
 * Splash Composable
 *
 */
@Composable
fun Splash() {
    val state = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            visibleState = state,
            enter = expandVertically(),
            exit = scaleOut()
        )  {
            Image(
                painter = painterResource(id = R.drawable.easycart_logo),
                contentDescription = "Profile photo",
                modifier = Modifier
                    .size(height = 200.dp, width = 200.dp)
            )
        }
    }
}