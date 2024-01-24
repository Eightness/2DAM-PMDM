/**
 * @author Albert Lozano Blasco
 * @version 2.1
 */

package com.albertlozano.albertfinal.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.albertlozano.albertfinal.R
import com.albertlozano.albertfinal.navigation.Routes

/**
 * AuthorScreen Composable
 *
 * @param navController
 */
@Composable
fun AuthorScreen(navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.myself),
            contentDescription = "Profile Photo",
            modifier = Modifier
                .size(150.dp)
                .padding(4.dp)
                .clip(CircleShape)
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.onSurface,
                    shape = CircleShape
                )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(R.string.appMadeBy),
            fontSize = 15.sp,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = stringResource(R.string.albertLozanoBlasco),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.padding(50.dp))
        Button(
            onClick = {
                navController.navigate(Routes.MainScreen.routes)
            },
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onPrimaryContainer)
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Volver atrás", tint = MaterialTheme.colorScheme.primaryContainer)
        }
    }
}