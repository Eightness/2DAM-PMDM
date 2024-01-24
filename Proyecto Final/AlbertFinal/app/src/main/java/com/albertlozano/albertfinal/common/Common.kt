/**
 * @author Albert Lozano Blasco
 * @version 2.1
 */

package com.albertlozano.albertfinal.common


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.albertlozano.albertfinal.R
import com.albertlozano.albertfinal.navigation.Routes
import com.albertlozano.albertfinal.viewmodel.MainScreenViewModel

/**
 * TopCenterAppBarCustom Composable
 *
 * @param navController
 * @param mainScreenViewModel
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopCenterAppBarCustom(navController: NavController, mainScreenViewModel: MainScreenViewModel) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        title = {
            Image(
                painter = painterResource(id = R.drawable.easycart_logo_horizontal),
                contentDescription = "Logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(horizontal = 100.dp, vertical = 100.dp)
            )
        },
        navigationIcon = {
            CustomDropDownMenu(navController, mainScreenViewModel)
        }
    )
}

/**
 * CustomDropDownMenu Composable
 *
 * @param navController
 * @param mainScreenViewModel
 */
@Composable
fun CustomDropDownMenu(navController: NavController, mainScreenViewModel: MainScreenViewModel) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    val userName by mainScreenViewModel.userName.observeAsState(initial = "Albert Lozano Blasco")
    IconButton(
        onClick = {
            expanded = true
        }
    ) {
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Menu",
            tint = MaterialTheme.colorScheme.primary
        )
    }
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = {
            expanded = false
        }
    ) {
        DropdownMenuItem(
            text = {
                Text(text = userName)
            },
            onClick = {

            },
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.defaultphoto),
                    contentDescription = "Profile photo",
                    modifier = Modifier
                        .size(height = 30.dp, width = 30.dp)
                        .clip(CircleShape)
                )
            }
        )
        DropdownMenuItem(
            text = {
                Text(text = stringResource(R.string.myShoppingCart))
            },
            onClick = {
                navController.navigate(Routes.MainScreen.routes)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Main Screen",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        )
        DropdownMenuItem(
            text = {
                Text(text = stringResource(R.string.add))
            },
            onClick = {
                navController.navigate(Routes.AddScreen.routes)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Screen",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        )
        DropdownMenuItem(
            text = {
                Text(text = stringResource(R.string.logOut))
            },
            onClick = {
                mainScreenViewModel.deleteUserPreferences()
                navController.navigate(Routes.OnBoardingScreen.routes)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Logout,
                    contentDescription = "OnBoarding Screen",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        )
        DropdownMenuItem(
            text = {
                Text(text = stringResource(R.string.author))
            },
            onClick = {
                navController.navigate(Routes.AuthorScreen.routes)
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Author Screen",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        )
    }
}