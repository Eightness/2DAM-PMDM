/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano.rickmortycardsalbert.ui.screens.mainscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.albertlozano.rickmortycardsalbert.R
import com.albertlozano.rickmortycardsalbert.navigation.Routes

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(navController: NavController) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.rymlogo),
                        contentDescription = stringResource(R.string.rick_and_morty_logo)
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
                        DropdownMenuItem(text = { Text(text = stringResource(R.string.main)) }, onClick = { })
                        DropdownMenuItem(text = { Text(text = stringResource(R.string.team)) }, onClick = {
                            navController.navigate(route = Routes.SecondScreen.route)
                        })
                    }
                }
            )
        }
    ){
        Spacer(modifier = Modifier.height(25.dp))
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ){
            Image(
                painter = painterResource(id = R.drawable.rymportal),
                contentDescription = stringResource(R.string.rick_and_morty_portal)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Button(onClick = {  }) {
                Text(text = stringResource(R.string.start_game))
            }
        }
    }
}