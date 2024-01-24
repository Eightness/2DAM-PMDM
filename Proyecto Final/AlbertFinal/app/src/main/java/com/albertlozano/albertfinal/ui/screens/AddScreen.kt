/**
 * @author Albert Lozano Blasco
 * @version 2.1
 */

package com.albertlozano.albertfinal.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.EuroSymbol
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.albertlozano.albertfinal.R
import com.albertlozano.albertfinal.common.TopCenterAppBarCustom
import com.albertlozano.albertfinal.navigation.Routes
import com.albertlozano.albertfinal.viewmodel.MainScreenViewModel

/**
 * AddScreen Composable.
 *
 * @param navController
 * @param mainScreenViewModel
 */
@Composable
fun AddScreen(navController: NavHostController, mainScreenViewModel: MainScreenViewModel) {
    Scaffold(
        containerColor = Color.White,
        contentColor = MaterialTheme.colorScheme.primary,
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopCenterAppBarCustom(navController, mainScreenViewModel)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Routes.MainScreen.routes)
                },
                containerColor = contentColorFor(MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Volver atrás",
                    tint = MaterialTheme.colorScheme.primaryContainer
                )
            }
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            var inputProductName by rememberSaveable { mutableStateOf("") }
            var inputSupermaket by rememberSaveable { mutableStateOf("") }
            var inputPrice by rememberSaveable { mutableStateOf("") }

            Spacer(modifier = Modifier.padding(innerPadding))
            TextField(
                colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.primary),
                value = inputProductName,
                onValueChange = { input ->
                    inputProductName = input
                },
                label = {
                    Text(
                        text = stringResource(R.string.productName)
                    )
                },
                leadingIcon = {
                    Icon(
                        tint = MaterialTheme.colorScheme.primary,
                        imageVector = Icons.Default.AddShoppingCart, contentDescription = "Icono del campo"
                    )
                },
            )
            Spacer(modifier = Modifier.padding(8.dp))
            TextField(
                colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.primary),
                value = inputSupermaket,
                onValueChange = { input ->
                    inputSupermaket = input
                },
                label = {
                    Text(
                        text = stringResource(R.string.productSupermarket)
                    )
                },
                leadingIcon = {
                    Icon(
                        tint = MaterialTheme.colorScheme.primary,
                        imageVector = Icons.Default.ShoppingBasket, contentDescription = "Icono del campo"
                    )
                }
            )
            Spacer(modifier = Modifier.padding(8.dp))
            TextField(
                colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.primary),
                value = inputPrice,
                onValueChange = { input ->
                    inputPrice = input
                },
                label = {
                    Text(
                        text = stringResource(R.string.productPrice)
                    )
                },
                leadingIcon = {
                    Icon(
                        tint = MaterialTheme.colorScheme.primary,
                        imageVector = Icons.Default.EuroSymbol, contentDescription = "Icono del campo"
                    )
                              },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.padding(25.dp))
            Button(
                onClick = {
                    mainScreenViewModel.addProduct(inputProductName, inputSupermaket, inputPrice.toDouble())
                    inputProductName = ""
                    inputSupermaket = ""
                    inputPrice = ""
                    navController.navigate(Routes.MainScreen.routes)
                },
                enabled = (inputProductName != "" && inputSupermaket != "" && inputPrice != "")
            ) {
                AnimatedVisibility(visible = true) {
                    Text(
                        text = stringResource(id = R.string.add),
                        modifier = Modifier.size(width = 100.dp, height = 20.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
