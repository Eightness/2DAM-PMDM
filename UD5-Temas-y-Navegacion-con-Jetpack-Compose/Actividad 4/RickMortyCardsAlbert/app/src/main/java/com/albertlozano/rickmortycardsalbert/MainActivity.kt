/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano.rickmortycardsalbert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.albertlozano.rickmortycardsalbert.navigation.Navigation
import com.albertlozano.rickmortycardsalbert.ui.MyAppContent
import com.albertlozano.rickmortycardsalbert.ui.theme.RickMortyCardsAlbertTheme

/**
 * Class MainActivity. Main class that contains app's activity.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickMortyCardsAlbertTheme {
                MyAppContent {
                    Navigation()
                }
            }
        }
    }
}