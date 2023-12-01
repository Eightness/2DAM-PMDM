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
fun ThirdOnBoard(navController: NavController) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PeaceBetweenWorlds()
        Row {
            Button(onClick = {
                navController.navigate(route = Routes.FourthOnBoard.route)
            }) {
                Text(text = stringResource(R.string.next))
            }
        }
    }
}

@Composable
fun PeaceBetweenWorlds() {
    Text(text = stringResource(R.string.peace_between_worlds), fontSize = 25.sp)
    Spacer(modifier = Modifier.height(15.dp))
    Image(painter = painterResource(id = R.drawable.pazentremundos), contentDescription = "")
    Spacer(modifier = Modifier.height(15.dp))
}