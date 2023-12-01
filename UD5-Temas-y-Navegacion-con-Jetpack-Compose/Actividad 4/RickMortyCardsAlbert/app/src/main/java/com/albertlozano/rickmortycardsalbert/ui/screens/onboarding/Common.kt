/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano.rickmortycardsalbert.ui.screens.onboarding

import androidx.compose.animation.scaleIn
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.albertlozano.rickmortycardsalbert.R

@Composable
fun SkipAndNextButtons(navController: NavController, skipRoute: String, nextRoute: String) {
    scaleIn(
        initialScale = 0.0F,
        transformOrigin = TransformOrigin.Center
    )
    Button(onClick = {
        navController.popBackStack()
        navController.navigate(route = skipRoute)
    }) {
        Text(text = stringResource(R.string.skip))
    }
    Spacer(modifier = Modifier.width(25.dp))
    Button(onClick = {
        navController.navigate(route = nextRoute)
    }) {
        Text(text = stringResource(R.string.next))
    }
}