package com.albertlozano.conversoralbert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.albertlozano.conversoralbert.ui.theme.ConversorAlbertTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConversorAlbertTheme {
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
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "10000",
            fontSize = 75.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {}, colors = ButtonDefaults.buttonColors(Color(0xFF673AB7))) {
            Text(
                text = "Generar número", fontSize = 30.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Button(onClick = { /*TODO*/ }) {
                
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    ConversorAlbertTheme {
        Content()
    }
}