/**
 * @author Albert Lozano Blasco
 * @version 2.1
 */

package com.albertlozano.albertfinal.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.albertlozano.albertfinal.common.TopCenterAppBarCustom
import com.albertlozano.albertfinal.database.entities.Product
import com.albertlozano.albertfinal.navigation.Routes
import com.albertlozano.albertfinal.viewmodel.MainScreenViewModel

/**
 * ProductScreen Composable
 *
 * @param navController
 * @param mainScreenViewModel
 */
@Composable
fun ProductScreen(navController: NavHostController, mainScreenViewModel: MainScreenViewModel) {

    val product by mainScreenViewModel.selectedProduct.observeAsState(Product())

    Scaffold(
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
            modifier = Modifier
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.padding(15.dp))
            Text(
                text = product.name,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.padding(15.dp))
            Card(
                modifier = Modifier
                    .fillMaxSize(),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary)
            ) {
                Column(
                    modifier = Modifier
                        .padding(25.dp)
                ) {
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "Supermercado: ${product.supermarket}",
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "Precio del producto: ${product.price} €",
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.padding(25.dp))
                    Row {
                        Spacer(modifier = Modifier.width(36.dp))
                        Button(
                            onClick = {
                                mainScreenViewModel.deleteProduct(product)
                                navController.navigate(Routes.MainScreen.routes)
                            },
                            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onPrimaryContainer)
                        ) {
                            Icon(imageVector = Icons.Default.Delete, contentDescription = "Icono Eliminar", tint = MaterialTheme.colorScheme.primaryContainer)
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "Eliminar",
                                color = MaterialTheme.colorScheme.primaryContainer)
                        }
                        Spacer(modifier = Modifier.width(25.dp))
                        Button(
                            onClick = {
                                navController.navigate(Routes.EditScreen.routes)
                            },
                            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onPrimaryContainer)
                        ) {
                            Icon(imageVector = Icons.Default.Create, contentDescription = "Icono Editar", tint = MaterialTheme.colorScheme.primaryContainer)
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "Editar",
                                color = MaterialTheme.colorScheme.primaryContainer)
                        }
                    }
                }
            }
        }
    }
}