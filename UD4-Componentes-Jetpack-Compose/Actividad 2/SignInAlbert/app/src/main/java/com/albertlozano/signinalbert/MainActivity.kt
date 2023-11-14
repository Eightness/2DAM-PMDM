/**
 * @author Albert Lozano Blasco
 * @version 2.0
 */

package com.albertlozano.signinalbert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.albertlozano.signinalbert.ui.MyAppContent
import com.albertlozano.signinalbert.ui.screens.SignIn
import com.albertlozano.signinalbert.ui.theme.SignInAlbertTheme

/**
 * Class MainActivity. Main class that contains app's activity.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignInAlbertTheme {
                MyAppContent {
                    SignIn()
                }
            }
        }
    }
}