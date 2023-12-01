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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.albertlozano.rickmortycardsalbert.R
import com.albertlozano.rickmortycardsalbert.navigation.Routes

@Composable
fun ThirdOnBoard(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        PeaceBetweenWorlds(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                navController.navigate(route = Routes.FourthOnBoard.route)
            }) {
                Text(text = stringResource(R.string.next))
            }
        }
    }
}

@Composable
fun PeaceBetweenWorlds(modifier: Modifier = Modifier) {
    var isTextVisible by remember { mutableStateOf(false) }
    var isImageVisible by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        isTextVisible = true
        isImageVisible = true
    }

    val textAlpha by animateFloatAsState(
        targetValue = if (isTextVisible) 1f else 0f,
        animationSpec = tween(durationMillis = 1000),
        label = ""
    )

    val imageAlpha by animateFloatAsState(
        targetValue = if (isImageVisible) 1f else 0f,
        animationSpec = tween(durationMillis = 1000),
        label = ""
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize() then modifier
    ) {
        Text(
            text = stringResource(R.string.peace_between_worlds),
            fontSize = 25.sp,
            modifier = Modifier.alpha(textAlpha)
        )

        Spacer(modifier = Modifier.height(15.dp))

        Image(
            painter = painterResource(id = R.drawable.pazentremundos),
            contentDescription = "",
            modifier = Modifier
                .alpha(imageAlpha)
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))
    }
}
