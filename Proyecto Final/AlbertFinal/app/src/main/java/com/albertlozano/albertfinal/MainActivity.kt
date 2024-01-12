package com.albertlozano.albertfinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.albertlozano.albertfinal.navigation.Navigation
import com.albertlozano.albertfinal.ui.theme.ListAlbertTheme
import com.albertlozano.albertfinal.viewmodel.ProductViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val videogameViewModel by viewModels<ProductViewModel>()

        setContent {
            ListAlbertTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(videogameViewModel)
                }
            }
        }
    }
}
