/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano.workoutalbert.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.albertlozano.workoutalbert.R
import com.albertlozano.workoutalbert.navigation.Routes
import com.albertlozano.workoutalbert.viewmodel.CommonViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    commonViewModel: CommonViewModel,
) {
    //Attributes
    val userName: String by commonViewModel.userName.observeAsState(initial = "")
    val numRepetitions: Int by commonViewModel.numRepetitions.observeAsState(initial = 3)
    val motivationalQuotes: List<String> = listOf(
        "El esfuerzo constante produce resultados duraderos.",
        "Tú vs. Tú: Haz que cada día cuente.",
        "Suda hoy, sonríe mañana.",
        "La única mala sesión de entrenamiento es la que no tuviste.",
        "No pares hasta que te sientas orgulloso."
    )
    val motivationalQuote = motivationalQuotes.random()
    var canContinue = false

    //Main Column
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(25.dp)
    ){
        //Motivational Quote
        Text(
            text = motivationalQuote,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(50.dp))

        //TextField for the user to input his username.
        TextField(
            value = userName,
            onValueChange = {
                if (it.isNotBlank())
                    canContinue = true
                commonViewModel.updateUserName(it)
            }
        )
        Spacer(modifier = Modifier.height(50.dp))

        //Let the user select how many repetitions are going to be made
        commonViewModel.updateNumRepetitions(selectNumRepetitions())
        Spacer(modifier = Modifier.height(50.dp))

        //Button to navigate to the next screen
        Button(
            onClick = { navController.navigate(Routes.SecondScreen.route) },
            enabled = canContinue
        ) {
            Text(
                text = "Continuar"
            )
        }
        Spacer(modifier = Modifier.height(50.dp))

        //Author's information
        ShowAuthorInfo()
    }
}

@Composable
fun selectNumRepetitions(): Int {
    var times by rememberSaveable { mutableIntStateOf(3) }
    Row {
        Button(
            onClick = { times-- },
            enabled = times > 3
        ) {
            Text(
                text = "-",
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Button(
            onClick = { times++ },
            enabled = times < 20
        ) {
            Text(
                text = "+",
                fontSize = 20.sp
            )
        }

        AnimatedContent(
            targetState = times,
            transitionSpec = {
                if (targetState > initialState) {
                    (slideInVertically { height -> -height } + fadeIn())
                        .togetherWith(slideOutVertically { height -> height } + fadeOut())

                } else {
                    (slideInVertically { height -> height } + fadeIn())
                        .togetherWith(slideOutVertically { height -> -height } + fadeOut())
                }
            },
            label = ""
        ) {targetCount ->
            Text(
                text = "Repeticiones: $targetCount",
                modifier = Modifier.padding(10.dp)
            )
        }
    }
    return times
}

@Composable
fun ShowAuthorInfo() {
    Row {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.author),
                contentDescription = "",
                modifier = Modifier
                    .clip(CircleShape)
                    .height(50.dp)
                    .width(50.dp),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.width(10.dp))

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Aplicación desarrollada por:",
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = "Albert Lozano Blasco",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}