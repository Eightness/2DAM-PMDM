package com.albertlozano.listalbert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.albertlozano.listalbert.navigation.Navigation
import com.albertlozano.listalbert.ui.theme.ListAlbertTheme
import com.albertlozano.listalbert.viewmodel.VideogameViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val videogameViewModel by viewModels<VideogameViewModel>()

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
