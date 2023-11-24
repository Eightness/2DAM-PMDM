/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.example.albertdragonball.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.albertdragonball.R
import com.example.albertdragonball.ui.character.Character
import com.example.albertdragonball.ui.character.Character.Companion.getCharacters

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun DragonBall() {
    //Variables
    var selectedCharacter by rememberSaveable { mutableStateOf(Character.getCharacterFirstID() ) }
    var isSelected by rememberSaveable { mutableStateOf( false ) }
    var lazyListState by remember { mutableStateOf(LazyListState()) }

    //Variable to show Alert Dialog
    var showDialog by rememberSaveable { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
            showDialog = false
        }, title = {
            //Display the title message
            Text(text = "Albert Lozano Blasco", color = colorResource(id = R.color.orange))
        }, text = {
            Image(
                painter = painterResource(id = R.drawable.dragonball_logo),
                contentDescription = "jaja"
            )
        }, confirmButton = {
            //OK button to close the Alert Dialog
            Button(onClick = {
                // Callback when the OK button is clicked
                showDialog = false
            }, colors = ButtonDefaults.buttonColors(colorResource(id = R.color.orange))) {
                Text(text = "OK", color = colorResource(id = R.color.darkGreyOrangy))
            }
        }, containerColor = colorResource(id = R.color.darkGreyOrangy))
    }

    //Main app's component
    Scaffold(
        //Top Bar with Dragon Ball logos and author's name
        topBar = {
            CenterAlignedTopAppBar(title = {
                Image(
                    painter = painterResource(id = R.drawable.dragonball_logo),
                    contentDescription = "Dragon Ball logo",
                    Modifier.size(150.dp)
                )
            }, navigationIcon = {
                Image(
                    painter = painterResource(id = R.drawable.dragonball_4stars),
                    contentDescription = "4 stars",
                    Modifier.size(45.dp)
                )
            }, actions = {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Akira", fontSize = 15.sp, fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Toriyama", fontSize = 15.sp, fontWeight = FontWeight.Bold
                    )
                }
            }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = colorResource(id = R.color.darkGreyOrangy),
                actionIconContentColor = colorResource(id = R.color.orange)
            ), modifier = Modifier.padding(5.dp)
            )
        },
        //Button to show the app's author information. A photo and a text
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog = true },
                containerColor = colorResource(id = R.color.orange),
                contentColor = colorResource(id = R.color.darkGreyOrangy)
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Author",
                )
            }
        },
        //Button's position in the Scaffold
        floatingActionButtonPosition = FabPosition.End
    ) {
        Row(
            Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.darkGreyOrangy))
        ) {
            //Left Column, contains all Dragon Ball characters, listed by alphabetical order
            LazyColumn(
                Modifier
                    .weight(4f)
                    .padding(it)
                    .fillMaxHeight()
                    .background(colorResource(id = R.color.darkGreyOrangy))
            ) {
                val groupedCharacters: Map<Char, List<Character>> =
                    Character.sorted().groupBy { it.spanishName[0] }
                groupedCharacters.forEach { (header, characters) ->
                    stickyHeader {
                        Text(
                            text = header.toString(),
                            fontSize = 30.sp,
                            color = colorResource(id = R.color.orange),
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .background(colorResource(id = R.color.darkGreyOrangy))
                                .fillMaxWidth()
                        )
                        Divider(
                            color = colorResource(id = R.color.maroon), thickness = 4.dp
                        )
                    }
                    items(characters) { character ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .background(colorResource(id = R.color.veryLightGreyOrangy)),
                                //horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = character.spanishName,
                                color = colorResource(id = R.color.orange),
                                modifier = Modifier
                                    .padding(start = 30.dp)
                                    .clickable {
                                        selectedCharacter = character.id
                                        isSelected = true
                                        lazyListState = LazyListState()
                                    }
                            )
                            if (selectedCharacter == character.id && isSelected) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "icon",
                                    tint = colorResource(id = R.color.orange)
                                )
                            }
                        }
                    }
                }
            }
            //Right Column, contains all information about the selected Dragon Ball character
            LazyColumn(
                Modifier
                    .weight(6f)
                    .padding(it)
                    .fillMaxHeight()
                    .background(colorResource(id = R.color.white))
            ) {

            }
        }
    }
}