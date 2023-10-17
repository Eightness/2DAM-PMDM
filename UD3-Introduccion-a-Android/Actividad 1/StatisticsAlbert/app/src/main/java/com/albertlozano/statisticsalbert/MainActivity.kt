package com.albertlozano.statisticsalbert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.albertlozano.statisticsalbert.ui.theme.StatisticsAlbertTheme

/**
 * Clase principal de la actividad de la aplicación.
 *
 * Esta clase representa la actividad principal de la aplicación y controla la creación de la interfaz de usuario.
 * Se encarga de configurar el tema, el fondo y cargar el contenido principal en la interfaz de usuario.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StatisticsAlbertTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Content()
                }
            }
        }
    }
}

/**
 * Función que define y muestra la interfaz de usuario de estadísticas de la aplicación.
 *
 * Esta función se encarga de componer y mostrar la interfaz de usuario principal de la aplicación de estadísticas.
 * Permite llevar un seguimiento de las estadísticas de personas, patinetes, bicicletas y coches, así como reiniciar
 * o resetear las estadísticas. Además, muestra el porcentaje de cada categoría con respecto al total cuando
 * hay datos válidos disponibles.
 *
 * @see rememberSaveable
 * @see mutableStateOf
 * @see Text
 * @see Button
 * @see Column
 * @see Row
 * @see Spacer
 */
@Composable
fun Content() {
    var totalStatistics: Int by rememberSaveable { mutableStateOf(0) }
    var peopleStatistic: Int by rememberSaveable { mutableStateOf(0) }
    var electricScooterStatistic: Int by rememberSaveable { mutableStateOf(0) }
    var bicycleStatistic: Int by rememberSaveable { mutableStateOf(0) }
    var carStatistic: Int by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Estadísticas Albert", fontSize = 35.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Text(
                text = "Total: $totalStatistics", fontSize = 30.sp
            )
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                    peopleStatistic = 0
                    electricScooterStatistic = 0
                    bicycleStatistic = 0
                    carStatistic = 0
                    totalStatistics = 0
                }, colors = ButtonDefaults.buttonColors(Color(0xFF6FACB4))
            ) {
                Text(
                    text = "Reiniciar todo", fontSize = 20.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Personas:", fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            Text(
                text = "$peopleStatistic", fontSize = 30.sp
            )
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                    peopleStatistic++
                    totalStatistics++
                }, colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50))
            ) {
                Text(
                    text = "+1", fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                    if (peopleStatistic > 0) {
                        peopleStatistic--
                        totalStatistics--
                    }
                }, colors = ButtonDefaults.buttonColors(Color(0xFFF44336))
            ) {
                Text(
                    text = "-1", fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                    totalStatistics -= peopleStatistic
                    peopleStatistic = 0
                }, colors = ButtonDefaults.buttonColors(Color(0xFF6FACB4))
            ) {
                Text(
                    text = "Reset", fontSize = 20.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Patinetes:", fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            Text(
                text = "$electricScooterStatistic", fontSize = 30.sp
            )
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                    electricScooterStatistic++
                    totalStatistics++
                }, colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50))
            ) {
                Text(
                    text = "+1", fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                    if (electricScooterStatistic > 0) {
                        electricScooterStatistic--
                        totalStatistics--
                    }
                }, colors = ButtonDefaults.buttonColors(Color(0xFFF44336))
            ) {
                Text(
                    text = "-1", fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                    totalStatistics -= electricScooterStatistic
                    electricScooterStatistic = 0
                }, colors = ButtonDefaults.buttonColors(Color(0xFF6FACB4))
            ) {
                Text(
                    text = "Reset", fontSize = 20.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Bicicletas:", fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            Text(
                text = "$bicycleStatistic", fontSize = 30.sp
            )
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                    bicycleStatistic++
                    totalStatistics++
                }, colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50))
            ) {
                Text(
                    text = "+1", fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                    if (bicycleStatistic > 0) {
                        bicycleStatistic--
                        totalStatistics--
                    }
                }, colors = ButtonDefaults.buttonColors(Color(0xFFF44336))
            ) {
                Text(
                    text = "-1", fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                    totalStatistics -= bicycleStatistic
                    bicycleStatistic = 0
                }, colors = ButtonDefaults.buttonColors(Color(0xFF6FACB4))
            ) {
                Text(
                    text = "Reset", fontSize = 20.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Coches:", fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            Text(
                text = "$carStatistic", fontSize = 30.sp
            )
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                    carStatistic++
                    totalStatistics++
                }, colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50))
            ) {
                Text(
                    text = "+1", fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                    if (carStatistic > 0) {
                        carStatistic--
                        totalStatistics--
                    }
                }, colors = ButtonDefaults.buttonColors(Color(0xFFF44336))
            ) {
                Text(
                    text = "-1", fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                    totalStatistics -= carStatistic
                    carStatistic = 0
                }, colors = ButtonDefaults.buttonColors(Color(0xFF6FACB4))
            ) {
                Text(
                    text = "Reset", fontSize = 20.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column {
            Text(
                text = "Estadísticas:",
                fontSize = 20.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            if (totalStatistics > 0) {
                Text(
                    text = """
                        |Personas: ${
                        String.format(
                            "%.2f", (peopleStatistic.toDouble() / totalStatistics.toDouble()) * 100
                        )
                    } %
                        |Patinetes: ${
                        String.format(
                            "%.2f",
                            (electricScooterStatistic.toDouble() / totalStatistics.toDouble()) * 100
                        )
                    } %
                        |Bicicletas: ${
                        String.format(
                            "%.2f", (bicycleStatistic.toDouble() / totalStatistics.toDouble()) * 100
                        )
                    } %
                        |Coches: ${
                        String.format(
                            "%.2f", (carStatistic.toDouble() / totalStatistics.toDouble()) * 100
                        )
                    } %
                        """.trimMargin("|"), fontSize = 20.sp
                )
            } else {
                Text(
                    text = """
                        |Personas: 0.00 %
                        |Patinetes: 0.00 %
                        |Bicicletas: 0.00 %
                        |Coches: 0.00 %
                        """.trimMargin("|"), fontSize = 20.sp
                )
            }

        }
    }
}

/**
 * Función de vista previa utilizada para previsualizar la interfaz de usuario principal de la aplicación.
 *
 * Esta función compone y muestra una vista previa de la interfaz de usuario principal de la aplicación.
 * Utiliza el tema `StatisticsAlbertTheme` y carga el contenido principal utilizando la función `Content`.
 *
 * @see StatisticsAlbertTheme
 * @see Content
 */
@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    StatisticsAlbertTheme {
        Content()
    }
}