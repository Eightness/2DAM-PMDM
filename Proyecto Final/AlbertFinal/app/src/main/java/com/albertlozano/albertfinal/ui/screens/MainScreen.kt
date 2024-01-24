/**
 * @author Albert Lozano Blasco
 * @version 2.1
 */

package com.albertlozano.albertfinal.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.albertlozano.albertfinal.R
import com.albertlozano.albertfinal.database.entities.Product
import com.albertlozano.albertfinal.navigation.Routes
import com.albertlozano.albertfinal.common.TopCenterAppBarCustom
import com.albertlozano.albertfinal.viewmodel.MainScreenViewModel

/**
 * MainScreen Composable.
 *
 * @param navController
 * @param mainScreenViewModel
 */
@Composable
fun MainScreen(
    navController: NavHostController, mainScreenViewModel: MainScreenViewModel
) {
    mainScreenViewModel.getAllProducts()
    mainScreenViewModel.loadUser()

    val productList by mainScreenViewModel.productList.observeAsState(initial = emptyList())

    Scaffold(
        containerColor = MaterialTheme.colorScheme.onPrimary,
        contentColor = MaterialTheme.colorScheme.primaryContainer,
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopCenterAppBarCustom(navController, mainScreenViewModel)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Routes.AddScreen.routes)
                },
                containerColor = contentColorFor(MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Añadir producto"
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(R.string.shoppingCart),
                color = MaterialTheme.colorScheme.primary,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .weight(9.1f)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                ) {
                    items(productList) { product ->
                        ProductItem(
                            product,
                            onDelete = {
                                mainScreenViewModel.deleteProduct(product)
                            },
                            mainScreenViewModel = mainScreenViewModel,
                            navController = navController
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .weight(1f)
            ) {
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = stringResource(R.string.thanksForUsing),
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }
    }
}

/**
 * ProductItem Composable.
 *
 * @param product
 * @param onDelete
 * @param mainScreenViewModel
 * @param navController
 */
@Composable
fun ProductItem(
    product: Product,
    onDelete: () -> Unit,
    mainScreenViewModel: MainScreenViewModel,
    navController: NavHostController
) {
    ListItem(
        modifier = Modifier
            .height(50.dp)
            .padding(4.dp)
            .clip(CircleShape)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = CircleShape
            )
            .clickable {
                mainScreenViewModel.onProductClicked(product)
                navController.navigate(Routes.ProductScreen.routes)
            },
        headlineContent = {
            Text(
                text = product.name,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = MaterialTheme.colorScheme.primary
            )
        },
        leadingContent = {
            Icon(
                imageVector = Icons.Default.ArrowRight,
                contentDescription = "Icono producto",
                tint = MaterialTheme.colorScheme.primary
            )
        },
        colors = ListItemDefaults.colors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        trailingContent = {
            IconButton(
                onClick = {
                    onDelete()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Icono eliminar",
                    tint = MaterialTheme.colorScheme.secondary
                )
            }
        }
    )
}