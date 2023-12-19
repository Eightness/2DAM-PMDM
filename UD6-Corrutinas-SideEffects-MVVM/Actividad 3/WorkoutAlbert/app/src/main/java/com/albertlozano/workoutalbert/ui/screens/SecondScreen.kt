/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano.workoutalbert.ui.screens

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.albertlozano.workoutalbert.navigation.Routes
import com.albertlozano.workoutalbert.viewmodel.CommonViewModel
import com.albertlozano.workoutalbert.viewmodel.WorkoutViewModel

@Composable
fun SecondScreen(
    navController: NavController,
    workoutViewModel: WorkoutViewModel,
    commonViewModel: CommonViewModel
) {
    //Attributes
    val userName: String by commonViewModel.userName.observeAsState(initial = "")
    val numRepetitions: Int by commonViewModel.numRepetitions.observeAsState(initial = 3)

    //Main Column
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        //Show username
        Text(
            text = userName,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(50.dp))

        //Show number of repetitions
        Text(
            text = "$numRepetitions",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(50.dp))

        //Un espacio donde aparecerá la imagen con el ejercicio a realizar
        ExerciseGif(exerciseImage = 1)
        Spacer(modifier = Modifier.height(50.dp))

        //Un botón para comenzar el ejercicio
        Button(
            onClick = { workoutViewModel.startExercise(numRepetitions, commonViewModel.updateNumRepetitions(numRepetitions)) },
            enabled = true
        ) {
            Text(
                text = "Continuar"
            )
        }
        Spacer(modifier = Modifier.height(50.dp))

        //Un botón para volver a la ventana anterior (popBackStack)
        Button(
            onClick = { navController.navigate(Routes.MainScreen.route) },
            enabled = true
        ) {
            Text(
                text = "Continuar"
            )
        }
    }
}

@Composable
fun ExerciseGif(exerciseImage: Int) {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest
                .Builder(context)
                .data(data = exerciseImage)
                .build(),
            imageLoader = imageLoader
        ),
        contentDescription = "Exercise",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    )
}