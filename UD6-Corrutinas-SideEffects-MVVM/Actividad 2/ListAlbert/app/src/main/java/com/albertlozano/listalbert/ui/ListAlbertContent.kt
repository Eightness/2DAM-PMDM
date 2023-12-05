package com.albertlozano.listalbert.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.albertlozano.listalbert.ui.theme.ListAlbertTheme

/**
 * Function MyAppContent. Contains the app's surface and calls ui components.
 */
@Composable
fun MyAppContent(content: @Composable () -> Unit) {
    ListAlbertTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}