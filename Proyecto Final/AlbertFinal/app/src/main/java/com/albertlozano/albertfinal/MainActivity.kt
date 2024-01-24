/**
 * @author Albert Lozano Blasco
 * @version 2.1
 */

package com.albertlozano.albertfinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.albertlozano.albertfinal.ui.theme.AlbertFinalTheme
import com.albertlozano.albertfinal.navigation.Navigation
import com.albertlozano.albertfinal.viewmodel.MainScreenViewModel

/**
 * MainActivity
 *
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainScreenViewModel by viewModels<MainScreenViewModel>()

        setContent {
            AlbertFinalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    Navigation(mainScreenViewModel)
                }
            }
        }
    }
}
