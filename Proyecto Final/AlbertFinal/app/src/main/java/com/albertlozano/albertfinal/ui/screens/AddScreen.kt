package com.albertlozano.albertfinal.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.albertlozano.albertfinal.R
import com.albertlozano.albertfinal.navigation.Routes
import com.albertlozano.albertfinal.viewmodel.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddScreen(navController: NavController, productViewModel: ProductViewModel) {
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
        //ScrollState variable
        val scrollstate = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollstate),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            //Data variables
            var name by rememberSaveable { mutableStateOf("") }
            var supermarket by rememberSaveable { mutableStateOf("") }
            var price by rememberSaveable { mutableStateOf("") }
            var quantity by rememberSaveable { mutableStateOf("") }

            Text(
                text = "Añadir producto",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(15.dp))

            CustomDataField(textFieldValue = name,
                label = "Nombre",
                placeholder = "Nombre del producto",
                leadingIcon = Icons.Default.Search,
                trailingIcon = Icons.Default.Create,
                onValueChanged = { name = it })
            Spacer(modifier = Modifier.height(15.dp))
            CustomDataField(textFieldValue = supermarket,
                label = "Supermercado",
                placeholder = "Nombre del supermercado",
                leadingIcon = Icons.Default.ShoppingCart,
                trailingIcon = Icons.Default.Create,
                onValueChanged = { supermarket = it })
            Spacer(modifier = Modifier.height(15.dp))
            CustomDataField(textFieldValue = price,
                label = "Precio",
                placeholder = "Precio del producto",
                leadingIcon = Icons.Default.Info,
                trailingIcon = Icons.Default.Create,
                onValueChanged = { price = it })
            Spacer(modifier = Modifier.height(15.dp))
            CustomDataField(textFieldValue = quantity,
                label = "Cantidad",
                placeholder = "Cantidad deseada",
                leadingIcon = Icons.Default.AddCircle,
                trailingIcon = Icons.Default.Create,
                onValueChanged = { quantity = it })
            Spacer(modifier = Modifier.height(15.dp))
            Button(
                onClick = {
                    //Insert into database
                    navController.navigate(Routes.MainScreen.route)
                }
            ) {
                Text(text = "Añadir")
            }
        }
    }
}

//CUSTOM COMPONENTS
//--------------------------------------------------------------------------------------------------

/**
 * Function CustomDataField. Contains an icon and an OutlinedTextField, allowing user interaction.
 *
 * @param textFieldValue The current value of the text field.
 * @param label The label or prompt for the text field.
 * @param placeholder The placeholder text displayed in the text field when empty.
 * @param leadingIcon The leading icon displayed before the text field.
 * @param trailingIcon The trailing icon displayed after the text field.
 * @param onValueChanged A callback function triggered when the value of the text field changes.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDataField(
    textFieldValue: String,
    label: String,
    placeholder: String,
    leadingIcon: ImageVector,
    trailingIcon: ImageVector,
    onValueChanged: (String) -> Unit
) {
    Row {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Add spacing for visual separation
            Spacer(modifier = Modifier.height(24.dp))
            //Display the leading icon
            Icon(
                imageVector = leadingIcon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        }

        //Add horizontal spacing between the icon and text field
        Spacer(modifier = Modifier.width(25.dp))

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Create the OutlinedTextField with specified parameters
            OutlinedTextField(value = textFieldValue, onValueChange = {
                onValueChanged(it)
            }, label = {
                Text(
                    text = label, color = MaterialTheme.colorScheme.primary
                )
            }, placeholder = {
                Text(
                    text = placeholder, color = MaterialTheme.colorScheme.secondary
                )
            }, trailingIcon = {
                //Display the trailing icon
                Icon(
                    imageVector = trailingIcon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.secondary
                )
            })
        }
    }
}