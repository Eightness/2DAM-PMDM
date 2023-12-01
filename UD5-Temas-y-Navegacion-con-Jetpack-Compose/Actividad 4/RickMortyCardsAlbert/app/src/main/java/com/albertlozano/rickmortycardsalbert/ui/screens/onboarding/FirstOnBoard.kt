/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano.rickmortycardsalbert.ui.screens.onboarding

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.albertlozano.rickmortycardsalbert.R
import com.albertlozano.rickmortycardsalbert.navigation.Routes

@Composable
fun FirstOnBoard(navController: NavController) {
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        isVisible = true
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        RickAndMortyPhotos(isVisible = isVisible)
        Row {
            SkipAndNextButtons(navController = navController, skipRoute = Routes.FourthOnBoard.route, nextRoute = Routes.SecondOnBoard.route)
        }
    }
}

@Composable
fun RickAndMortyPhotos(isVisible: Boolean) {
    val alpha by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0f,
        animationSpec = tween(durationMillis = 2000),
        label = ""
    )

    Image(
        painter = painterResource(id = R.drawable.rymlogo),
        contentDescription = stringResource(id = R.string.rick_and_morty_logo),
        modifier = Modifier.alpha(alpha)
    )

    Spacer(modifier = Modifier.height(10.dp))

    Image(
        painter = painterResource(id = R.drawable.rymportal),
        contentDescription = stringResource(id = R.string.rick_and_morty_portal),
        modifier = Modifier.alpha(alpha)
    )
}
