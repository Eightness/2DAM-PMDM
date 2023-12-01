/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano.rickmortycardsalbert.ui.screens.mainscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.albertlozano.rickmortycardsalbert.R
import com.albertlozano.rickmortycardsalbert.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(navController: NavController) {
    TopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.rymlogo),
                contentDescription = stringResource(R.string.rick_and_morty_logo),
                Modifier.size(100.dp)
            )
        },
        navigationIcon = {
            var dropped by rememberSaveable { mutableStateOf(false) }
            IconButton(
                onClick = { dropped = true }
            ){
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = stringResource(R.string.dropdown_icon)
                )
            }
            DropdownMenu(expanded = dropped, onDismissRequest = { }) {
                DropdownMenuItem(text = { Text(text = stringResource(R.string.main)) }, onClick = {
                    navController.navigate(route = Routes.FirstScreen.route)
                })
                DropdownMenuItem(text = { Text(text = stringResource(R.string.team)) }, onClick = {
                    navController.navigate(route = Routes.SecondScreen.route)
                })
            }
        }
    )
}