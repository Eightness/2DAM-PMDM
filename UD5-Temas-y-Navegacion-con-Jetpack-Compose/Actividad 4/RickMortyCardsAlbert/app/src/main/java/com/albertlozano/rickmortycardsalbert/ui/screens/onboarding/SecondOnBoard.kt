/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano.rickmortycardsalbert.ui.screens.onboarding

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.albertlozano.rickmortycardsalbert.R
import com.albertlozano.rickmortycardsalbert.navigation.Routes

@Composable
fun SecondOnBoard(navController: NavController) {
    LazyColumn (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        content = {
            item {
                Cards()
                Row {
                    SkipAndNextButtons(navController = navController, skipRoute = Routes.FourthOnBoard.route, nextRoute = Routes.ThirdOnBoard.route)
                }
            }
        }
    )
}

@Composable
fun Cards() {
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        isVisible = true
    }

    val slideOffset by animateFloatAsState(
        targetValue = if (isVisible) 0f else 500f,
        animationSpec = tween(durationMillis = 1000),
        label = ""
    )

    Spacer(modifier = Modifier.height(15.dp))
    Text(text = stringResource(R.string.choose_and_fight), fontSize = 25.sp)

    Spacer(modifier = Modifier.height(15.dp))
    Image(
        painter = painterResource(id = R.drawable.card1),
        contentDescription = "",
        modifier = Modifier.graphicsLayer(translationY = slideOffset)
    )

    Spacer(modifier = Modifier.height(15.dp))
    Image(
        painter = painterResource(id = R.drawable.card2),
        contentDescription = "",
        modifier = Modifier.graphicsLayer(translationY = slideOffset)
    )

    Spacer(modifier = Modifier.height(15.dp))
    Image(
        painter = painterResource(id = R.drawable.card3),
        contentDescription = "",
        modifier = Modifier.graphicsLayer(translationY = slideOffset)
    )

    Spacer(modifier = Modifier.height(15.dp))
}
