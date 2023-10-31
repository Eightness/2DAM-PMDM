package com.example.albertpadelscore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.albertpadelscore.ui.theme.AlbertPadelScoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlbertPadelScoreTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Content()
                }
            }
        }
    }
}

@Composable
fun Content() {
    //Team A variables
    var setPointsTeamA by rememberSaveable { mutableStateOf(0) }
    var gamePointsTeamA by rememberSaveable { mutableStateOf(0) }
    var currentGamePointsTeamA by rememberSaveable { mutableStateOf(0) }

    //Team B variables
    var setPointsTeamB by rememberSaveable { mutableStateOf(0) }
    var gamePointsTeamB by rememberSaveable { mutableStateOf(0) }
    var currentGamePointsTeamB by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Data

        //SETS
        Text(text = stringResource(id = R.string.sets), fontSize = dimensionResource(id = R.dimen.title_fontSize).value.sp, color = Color(0xFFFFFFFF), textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.green)))
        Spacer(modifier = Modifier.height(25.dp))
        Row {
            Text(text = "$setPointsTeamA", fontSize = dimensionResource(id = R.dimen.points_fontSize).value.sp, color = colorResource(id = R.color.blue), textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.width(140.dp))
            Text(text = "$setPointsTeamB", fontSize = dimensionResource(id = R.dimen.points_fontSize).value.sp, color = colorResource(id = R.color.orange), textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.height(25.dp))

        //GAMES
        Text(text = stringResource(id = R.string.games), fontSize = dimensionResource(id = R.dimen.title_fontSize).value.sp, color = Color(0xFFFFFFFF), textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.green)))
        Spacer(modifier = Modifier.height(25.dp))
        Row {
            Text(text = "$gamePointsTeamA", fontSize = dimensionResource(id = R.dimen.points_fontSize).value.sp, color = colorResource(id = R.color.blue), textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.width(140.dp))
            Text(text = "$gamePointsTeamB", fontSize = dimensionResource(id = R.dimen.points_fontSize).value.sp, color = colorResource(id = R.color.orange), textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.height(25.dp))

        //CURRENT GAME
        Text(text = stringResource(id = R.string.current_game), fontSize = dimensionResource(id = R.dimen.title_fontSize).value.sp, color = Color(0xFFFFFFFF), textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.green)))
        Spacer(modifier = Modifier.height(25.dp))
        Row {
            Text(text = "$currentGamePointsTeamA", fontSize = dimensionResource(id = R.dimen.points_fontSize).value.sp, color = colorResource(id = R.color.blue), textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.width(140.dp))
            Text(text = "$currentGamePointsTeamB", fontSize = dimensionResource(id = R.dimen.points_fontSize).value.sp, color = colorResource(id = R.color.orange), textAlign = TextAlign.Center)
        }

        //BUTTONS
        Row {
            Button(onClick = {
                if (setPointsTeamA < 2 && setPointsTeamB < 2) {
                    if (gamePointsTeamA == 6 && gamePointsTeamB == 6) {
                        currentGamePointsTeamA++
                        if (currentGamePointsTeamA > 6 && currentGamePointsTeamA - currentGamePointsTeamB >= 2) {
                            setPointsTeamA++
                            gamePointsTeamB = 0
                            gamePointsTeamA = 0
                            currentGamePointsTeamB = 0
                            currentGamePointsTeamA = 0
                        }
                    } else {
                        if (currentGamePointsTeamA < 40) {
                            if (currentGamePointsTeamA == 0) {
                                currentGamePointsTeamA = 15
                            } else if (currentGamePointsTeamA == 15) {
                                currentGamePointsTeamA = 30
                            } else if (currentGamePointsTeamA == 30) {
                                currentGamePointsTeamA = 40
                            }
                        } else if (currentGamePointsTeamA == 40) {
                            currentGamePointsTeamA = 0
                            currentGamePointsTeamB = 0
                            gamePointsTeamA++

                            if (gamePointsTeamA > 6 && gamePointsTeamA - gamePointsTeamB >= 2) {
                                setPointsTeamA++
                                gamePointsTeamA = 0
                                gamePointsTeamB = 0
                                currentGamePointsTeamA = 0
                                currentGamePointsTeamB = 0
                                if (setPointsTeamA == 2) {
                                    // El equipo A gana el partido
                                    // Impide que se sumen más puntos
                                }
                            }
                        }
                    }
                }
            }, colors = ButtonDefaults.buttonColors(colorResource(id = R.color.blue))) {
                Text(text = stringResource(id = R.string.teamA_points), fontSize = dimensionResource(id = R.dimen.button_fontSize).value.sp)
            }
            Spacer(modifier = Modifier.width(25.dp))
            Button(onClick = {
                if (setPointsTeamB < 2 && setPointsTeamA < 2) {
                    if (gamePointsTeamB == 6 && gamePointsTeamA == 6) {
                        currentGamePointsTeamB++
                        if (currentGamePointsTeamB > 6 && currentGamePointsTeamB - currentGamePointsTeamA >= 2) {
                            setPointsTeamB++
                            gamePointsTeamB = 0
                            gamePointsTeamA = 0
                            currentGamePointsTeamB = 0
                            currentGamePointsTeamA = 0
                        }
                    } else {
                        if (currentGamePointsTeamB < 40) {
                            if (currentGamePointsTeamB == 0) {
                                currentGamePointsTeamB = 15
                            } else if (currentGamePointsTeamB == 15) {
                                currentGamePointsTeamB = 30
                            } else if (currentGamePointsTeamB == 30) {
                                currentGamePointsTeamB = 40
                            }
                        } else if (currentGamePointsTeamB == 40) {
                            currentGamePointsTeamB = 0
                            currentGamePointsTeamA = 0
                            gamePointsTeamB++

                            if (gamePointsTeamB > 6 && gamePointsTeamB - gamePointsTeamA >= 2) {
                                setPointsTeamB++
                                gamePointsTeamB = 0
                                gamePointsTeamA = 0
                                currentGamePointsTeamB = 0
                                currentGamePointsTeamA = 0
                                if (setPointsTeamB == 2) {
                                    // El equipo A gana el partido
                                    // Impide que se sumen más puntos
                                }
                            }
                        }
                    }
                }
            }, colors = ButtonDefaults.buttonColors(colorResource(id = R.color.orange))) {
                Text(text = stringResource(id = R.string.teamB_points), fontSize = dimensionResource(id = R.dimen.button_fontSize).value.sp)
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row {
            Button(onClick = {
                gamePointsTeamA = 0
                gamePointsTeamB = 0
                currentGamePointsTeamA = 0
                currentGamePointsTeamB = 0
                setPointsTeamA = 0
                setPointsTeamB = 0
                             }, colors = ButtonDefaults.buttonColors(Color(0xFFF44336))) {
                Spacer(modifier = Modifier.width(50.dp))
                Text(text = stringResource(id = R.string.reset), fontSize = dimensionResource(id = R.dimen.button_fontSize).value.sp)
                Spacer(modifier = Modifier.width(50.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    AlbertPadelScoreTheme {
        Content()
    }
}