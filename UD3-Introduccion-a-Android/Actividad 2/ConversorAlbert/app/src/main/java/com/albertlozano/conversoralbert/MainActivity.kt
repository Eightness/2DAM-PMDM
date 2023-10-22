package com.albertlozano.conversoralbert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.albertlozano.conversoralbert.ui.theme.ConversorAlbertTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConversorAlbertTheme {
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
    var randomNumber by remember { mutableStateOf(0) }
    var binaryNumber by remember { mutableStateOf("") }
    var hexNumber by remember { mutableStateOf("") }
    var showConversions by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                randomNumber = Random.nextInt(1, 10001)
                hexNumber = ""
                binaryNumber = ""
                showConversions = true
            },
            colors = ButtonDefaults.buttonColors(Color(0xFF673AB7))
        ) {
            Text(text = "Generar número", fontSize = 30.sp)
        }

        if (showConversions) {
            Text(text = "$randomNumber", fontSize = 75.sp)
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Conversión a:", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(25.dp))

            Button(
                onClick = {
                    binaryNumber = randomNumber.toString(2).padStart(3, '0')
                },
                colors = ButtonDefaults.buttonColors(Color(0xFF3F51B5))
            ) {
                Text(text = "Binario", fontSize = 20.sp)
            }
            Text(text = binaryNumber, fontSize = 20.sp)

            Spacer(modifier = Modifier.height(25.dp))

            Button(
                onClick = {
                    hexNumber = randomNumber.toString(16).padStart(2, '0')
                },
                colors = ButtonDefaults.buttonColors(Color(0xFF3F51B5))
            ) {
                Text(text = "Hexadecimal", fontSize = 20.sp)
            }
            Text(text = hexNumber, fontSize = 20.sp)

            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "Volver a empezar:", fontSize = 20.sp)

            Button(
                onClick = {
                    randomNumber = 0
                    binaryNumber = ""
                    hexNumber = ""
                    showConversions = false
                },
                colors = ButtonDefaults.buttonColors(Color(0xFF673AB7))
            ) {
                Text(text = "Reset", fontSize = 20.sp)
            }
        }

        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Aplicación realizada por Albert Lozano.")
    }
}

@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    ConversorAlbertTheme {
        Content()
    }
}
