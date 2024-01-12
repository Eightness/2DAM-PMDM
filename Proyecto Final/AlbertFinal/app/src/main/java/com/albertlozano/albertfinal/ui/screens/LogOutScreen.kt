package com.albertlozano.albertfinal.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.albertlozano.albertfinal.viewmodel.ProductViewModel

@Composable
fun LogOutScreen(navController: NavController, productViewModel: ProductViewModel) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding()
            .fillMaxSize()
    ) {
        Text(
            text = "Gracias por usar la app.",
            fontSize = 25.sp
        )
    }
}