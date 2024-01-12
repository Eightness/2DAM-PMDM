package com.albertlozano.albertfinal.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.navigation.NavHostController
import com.albertlozano.albertfinal.R
import com.albertlozano.albertfinal.model.Product
import com.albertlozano.albertfinal.navigation.Routes
import com.albertlozano.albertfinal.viewmodel.ProductViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavHostController, productViewModel: ProductViewModel
) {
    val products: List<Product> by productViewModel.products.observeAsState(initial = emptyList())
    val isLoadingProducts: Boolean by productViewModel.isLoading.observeAsState(initial = false)
    val lazyListState by remember { mutableStateOf(LazyListState()) }

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
                        text = { Text(text = "Albert Lozano", fontWeight = FontWeight.Bold) },
                        onClick = {  }
                    )
                    Divider()
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
        Row(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.secondary)
        ) {
            if (isLoadingProducts) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.secondary)
                ) {
                    Text(
                        text = "Cargando...",
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White

                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    CircularProgressIndicator(
                        color = Color.White
                    )
                }
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondary)
                    .padding(vertical = 80.dp),
                state = lazyListState
            ) {
                items(products) { product ->
                    ProductCard(
                        product = product,
                        navController = navController,
                        productViewModel = productViewModel
                    )
                }
            }
            Button(
                onClick = { navController.navigate(Routes.ProductInfo.route) }
            ) {
                Image(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductCard(
    product: Product, navController: NavHostController, productViewModel: ProductViewModel
) {
    OutlinedCard(modifier = Modifier
        .padding(vertical = 4.dp, horizontal = 8.dp)
        .clickable {
            productViewModel.onProductClicked(product)
            navController.navigate(Routes.ProductInfo.route)
        }) {
        ListItem(headlineText = { Text(text = product.name) },
            supportingText = { Text(text = product.supermarket) },
            leadingContent = {
                if (product.favorite) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "producto",
                        tint = Color(0xFFFB8C00)
                    )
                }
            },
            trailingContent = {
                Icon(imageVector = Icons.Default.Delete,
                    contentDescription = "producto",
                    modifier = Modifier.clickable {
                        productViewModel.deleteProduct(product)
                    })
            })
    }
}
