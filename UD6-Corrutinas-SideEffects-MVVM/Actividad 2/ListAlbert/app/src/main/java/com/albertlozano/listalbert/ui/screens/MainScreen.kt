package com.albertlozano.listalbert.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.albertlozano.listalbert.model.Videogame
import com.albertlozano.listalbert.navigation.Routes
import com.albertlozano.listalbert.viewmodel.VideogameViewModel

@Composable
fun MainScreen(
    navController: NavHostController,
    videogameViewModel: VideogameViewModel
) {
    val videogames: List<Videogame> by videogameViewModel.videogame.observeAsState(initial = emptyList())
    val isLoadingVideogames: Boolean by videogameViewModel.isLoading.observeAsState(initial = false)

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(vertical = 8.dp)
    ) {
        items(videogames) {videogame ->
            VideogameCard(
                videogame = videogame,
                navController = navController,
                videogameViewModel = videogameViewModel
            )
        }
    }

    if (isLoadingVideogames) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Text(
                text = "Loading...",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black

            )
            Spacer(modifier = Modifier.height(20.dp))
            CircularProgressIndicator(
                color = Color.Black
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VideogameCard(
    videogame: Videogame,
    navController: NavHostController,
    videogameViewModel: VideogameViewModel
) {
    OutlinedCard(
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clickable {
                videogameViewModel.onVideogameClicked(videogame)
                navController.navigate(Routes.VideogameInfo.route)
            }
    ) {
        ListItem(
            headlineText = { Text(text = videogame.title) },
            supportingText = { Text(text = videogame.company) },
            leadingContent = {
                 if (videogame.favorite) {
                     Icon(
                         imageVector = Icons.Default.Star,
                         contentDescription = "videogame",
                         tint = Color(0xFFFB8C00)
                     )
                 }
            },
            trailingContent = {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "videogame",
                    modifier = Modifier.clickable {
                        videogameViewModel.deleteVideogame(videogame)
                    }
                )
            }
        )
    }
}
