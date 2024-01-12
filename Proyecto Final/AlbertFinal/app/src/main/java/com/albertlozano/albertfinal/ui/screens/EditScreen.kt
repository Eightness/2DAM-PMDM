package com.albertlozano.albertfinal.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.albertlozano.albertfinal.R
import com.albertlozano.albertfinal.navigation.Routes
import com.albertlozano.albertfinal.viewmodel.ProductViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreen(navController: NavController, productViewModel: ProductViewModel) {
    Scaffold(
        //Top Bar with Dragon Ball logos and author's name
        topBar = {
            CenterAlignedTopAppBar(title = {
                Image(
                    painter = painterResource(id = R.drawable.consum),
                    contentDescription = "app name",
                    Modifier.size(150.dp)
                )
            }, navigationIcon = {
                var dropped by rememberSaveable { mutableStateOf(false) }
                IconButton(
                    onClick = { dropped = true }
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "icono menu",
                        tint = Color.White
                    )
                }
                DropdownMenu(expanded = dropped, onDismissRequest = { dropped = false }) {
                    DropdownMenuItem(
                        text = { Text(text = "Principal") },
                        onClick = { navController.navigate(route = Routes.MainScreen.route) },
                        leadingIcon = { Icon(imageVector = Icons.Default.Home, contentDescription = "principal") }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Añadir") },
                        onClick = { navController.navigate(route = Routes.AddScreen.route) },
                        leadingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = "principal") }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Autor") },
                        onClick = { navController.navigate(route = Routes.AuthorScreen.route) },
                        leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "principal") }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Cerrar sesión") },
                        onClick = { navController.navigate(route = Routes.LogOutScreen.route) },
                        leadingIcon = { Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "principal") }
                    )
                }
            }, actions = {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Albert", fontSize = 15.sp, fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Lozano", fontSize = 15.sp, fontWeight = FontWeight.Bold
                    )
                }
            }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                actionIconContentColor = colorResource(id = R.color.white)
            )
            )
        },
        //Button to show the app's author information. A photo and a text
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = colorResource(id = R.color.white)
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "autor",
                )
            }
        },
        //Button's position in the Scaffold
        floatingActionButtonPosition = FabPosition.End
    ) {

    }
}