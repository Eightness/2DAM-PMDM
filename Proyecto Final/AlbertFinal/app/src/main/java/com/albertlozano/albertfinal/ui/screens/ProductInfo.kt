package com.albertlozano.albertfinal.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.albertlozano.albertfinal.model.Product
import com.albertlozano.albertfinal.viewmodel.ProductViewModel

@Composable
fun ProductInfo(
    navController: NavController,
    productViewModel: ProductViewModel
) {
    val product: Product by productViewModel.selectedProduct.observeAsState(Product())

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.clickable {
                navController.popBackStack()
            }
        ){
            Icon(
                imageVector = Icons.Default.ArrowBack, 
                contentDescription = "Volver"
            )
            Text(text = "Volver")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "producto"
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = product.name,
                fontSize = 30.sp
            )
        }
        
        Spacer(modifier = Modifier.height(20.dp))
        
        Text(
            text = product.supermarket,
            fontSize = 16.sp
        )

        Row {
            Spacer(modifier = Modifier.width(300.dp))
            Button(
                onClick = {
                    productViewModel.onFavoriteButtonClicked()
                },
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onPrimary)
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "favorito",
                    tint = if (product.favorite) Color(0xFFFB8C00) else Color.DarkGray
                )
            }
        }


        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.tertiary)
                .padding(8.dp)
        ) {
            Text(
                text = "Aquí se mostrará la información detallada del producto.",
                color = MaterialTheme.colorScheme.onTertiary
                )
        }
    }
}