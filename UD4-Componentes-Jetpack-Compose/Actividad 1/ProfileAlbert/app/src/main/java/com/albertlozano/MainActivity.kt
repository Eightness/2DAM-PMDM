/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.albertlozano.profilealbert.ui.MyAppContent
import com.albertlozano.profilealbert.ui.screens.Profile

/**
 * Class that contains the main activity.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppContent {
                Profile()
            }
        }
    }
}
