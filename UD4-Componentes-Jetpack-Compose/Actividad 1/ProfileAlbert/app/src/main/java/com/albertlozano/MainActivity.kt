package com.albertlozano.profilealbert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.albertlozano.profilealbert.ui.MyAppContent
import com.albertlozano.profilealbert.ui.screens.Profile

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
