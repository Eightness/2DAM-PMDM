/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano.rickmortycardsalbert.ui.screens.mainscreen

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.albertlozano.rickmortycardsalbert.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(navController: NavController) {
    Scaffold (
        topBar = {
            MyTopBar(navController = navController)
        }
    ){
        Spacer(modifier = Modifier.height(25.dp))
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ){
            FirstScreenContent()
        }
    }
}

@Composable
fun FirstScreenContent() {
    var isImageVisible by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        isImageVisible = true
    }

    val slideInOffset by animateDpAsState(
        targetValue = if (isImageVisible) 0.dp else 1000.dp,
        animationSpec = tween(durationMillis = 1000),
        label = ""
    )

    Image(
        painter = painterResource(id = R.drawable.rymportal),
        contentDescription = stringResource(R.string.rick_and_morty_portal),
        modifier = Modifier
            .offset(x = slideInOffset)
    )

    Spacer(modifier = Modifier.height(15.dp))

    Button(onClick = {  }) {
        Text(text = stringResource(R.string.start_game))
    }
}

