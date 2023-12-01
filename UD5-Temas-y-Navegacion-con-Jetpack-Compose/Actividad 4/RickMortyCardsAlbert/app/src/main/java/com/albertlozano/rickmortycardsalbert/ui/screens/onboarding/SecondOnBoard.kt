/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano.rickmortycardsalbert.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.albertlozano.rickmortycardsalbert.R
import com.albertlozano.rickmortycardsalbert.navigation.Routes

@Composable
fun SecondOnBoard(navController: NavController) {
    LazyColumn (
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            item {
                Cards()
                Row {
                    Button(onClick = { navController.navigate(route = Routes.FourthOnBoard.route) }) {
                        Text(text = stringResource(R.string.skip))
                    }
                    Spacer(modifier = Modifier.width(25.dp))
                    Button(onClick = { navController.navigate(route = Routes.FourthOnBoard.route) }) {
                        Text(text = stringResource(R.string.next))
                    }
                }
            }
        }
    )
}

@Composable
fun Cards() {
    Text(text = stringResource(R.string.choose_and_fight), fontSize = 25.sp)

    Spacer(modifier = Modifier.height(15.dp))
    Image(painter = painterResource(id = R.drawable.card1), contentDescription = "")
    Spacer(modifier = Modifier.height(15.dp))
    Image(painter = painterResource(id = R.drawable.card2), contentDescription = "")
    Spacer(modifier = Modifier.height(15.dp))
    Image(painter = painterResource(id = R.drawable.card3), contentDescription = "")
    Spacer(modifier = Modifier.height(15.dp))
}