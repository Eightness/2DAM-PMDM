/**
 * @author Albert Lozano Blasco
 * @version 2.1
 */

package com.albertlozano.albertfinal.ui.screens

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.albertlozano.albertfinal.R
import com.albertlozano.albertfinal.navigation.Routes
import com.albertlozano.albertfinal.viewmodel.MainScreenViewModel

/**
 * OnBoardingScreen Composable
 *
 * @param navController
 * @param mainScreenViewModel
 */
@SuppressLint("UnrememberedMutableState")
@Composable
fun OnBoardingScreen(navController: NavHostController, mainScreenViewModel: MainScreenViewModel) {
    val userName by mainScreenViewModel.userName.observeAsState(initial = "")
    val credentialsAreValid by derivedStateOf {
        userNameIsValid(userName)
    }
    var isRegistered by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.easycart_logo),
            contentDescription = "Logo",
            modifier = Modifier.size(width = 200.dp, height = 200.dp)
        )
        AnimatedVisibility(visible = true) {
            if (!isRegistered) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(40.dp)
                ) {
                    Spacer(modifier = Modifier.height(50.dp))
                    Text(
                        text = stringResource(R.string.easyCartWelcome),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = stringResource(R.string.easyCartDescription),
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Button(
                        onClick = {
                            isRegistered = !isRegistered
                        },
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onPrimaryContainer)
                    ) {
                        Text(
                            text = stringResource(R.string.logIn),
                            color = MaterialTheme.colorScheme.primaryContainer
                        )
                    }
                }
            }
        }

        if (isRegistered) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(40.dp)
            ) {
                Spacer(modifier = Modifier.height(50.dp))
                LaunchedEffect(key1 = true) {
                    mainScreenViewModel.loadDefaultProducts()
                }
                AnimatedVisibility(
                    visible = isRegistered,
                    enter = expandHorizontally()
                ) {
                    TextField (
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                            .fillMaxWidth(),
                        value = userName,
                        onValueChange = { mainScreenViewModel.onUserNameChange(it) },
                        singleLine = true,
                        label = {
                            Text(
                                text = stringResource(R.string.userName)
                            )
                        },
                        colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.onTertiaryContainer),
                        leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Icono del campo", tint = MaterialTheme.colorScheme.primary) }
                    )
                }
            }
        }
        Spacer(
            modifier = Modifier
                .padding(16.dp)
        )
        AnimatedVisibility(
            visible = credentialsAreValid,
            enter = expandHorizontally()
        ) {
            Button(
                onClick = {
                    mainScreenViewModel.saveUserName(userName)
                    navController.popBackStack()
                    navController.navigate(Routes.MainScreen.routes)
                },
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onPrimaryContainer)
            ) {
                Text(
                    text = stringResource(R.string.next),
                    color = MaterialTheme.colorScheme.primaryContainer)
            }
        }
    }
}

/**
 * userNameIsValid function.
 *
 * @param userName
 * @return
 */
fun userNameIsValid(userName: String): Boolean {
    val validUserName = Regex("^[a-zA-Z]{3,}\$")

    return userName.matches(validUserName)
}
