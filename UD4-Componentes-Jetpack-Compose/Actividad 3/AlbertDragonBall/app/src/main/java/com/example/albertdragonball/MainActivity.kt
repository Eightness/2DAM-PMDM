/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.example.albertdragonball

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.albertdragonball.ui.MyAppContent
import com.example.albertdragonball.ui.screens.DragonBall
import com.example.albertdragonball.ui.theme.AlbertDragonBallTheme

/**
 * Class MainActivity. Main class that contains app's activity.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlbertDragonBallTheme {
                MyAppContent {
                    DragonBall()
                }
            }
        }
    }
}
