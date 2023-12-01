/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano.rickmortycardsalbert.ui.screens.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.albertlozano.rickmortycardsalbert.R
import com.albertlozano.rickmortycardsalbert.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FourthOnBoard(navController: NavController) {
    var name by rememberSaveable { mutableStateOf("") }
    val checkName = Regex("^[a-zA-Z]{3,}+\$")
    Column {

    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = {  },
            placeholder = {  }
        )
        Button(
            onClick = { navController.navigate(route = Routes.FirstScreen.route)},
            enabled = checkName.matches(name)
            ) {
            Text(text = stringResource(R.string.continue_button))
        }
    }
}