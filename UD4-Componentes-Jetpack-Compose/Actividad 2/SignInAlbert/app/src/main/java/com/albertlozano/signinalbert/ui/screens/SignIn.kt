/**
 * @author Albert Lozano Blasco
 * @version 2.0
 */

package com.albertlozano.signinalbert.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.albertlozano.signinalbert.R

//MAIN FUNCTION
//--------------------------------------------------------------------------------------------------

/**
 * Function SignIn. Main function that contains all customed UI components.
 */
@Composable
fun SignIn() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(colorResource(id = R.color.white)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "DATOS PERSONALES",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(25.dp))
        //Text attributes fields
        Row {
            SignInTexts()
        }
        //Elements
        Row {

        }
        //Buttons
        Row {

        }
        //Information
        Row {

        }
    }
}

//CUSTOM COMPOSABLES
//--------------------------------------------------------------------------------------------------

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInText(text: String, label: String, placeholder: String, leadingIcon: ImageVector, trailingIcon: ImageVector) {
    var textFieldValue by rememberSaveable { mutableStateOf("") }
    Row (

    ){
        Column (
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = text
            )

            Spacer(modifier = Modifier.width(5.dp))

            TextField(
                value = textFieldValue,
                onValueChange = { textFieldValue = it},
                label = { Text(label)},
                placeholder = { Text(text = placeholder)},
                leadingIcon = { Icon(imageVector = leadingIcon, contentDescription = null)},
                trailingIcon = { Icon(imageVector = trailingIcon, contentDescription = null)}
            )
        }
    }
}

@Composable
fun SignInTexts() {
    Column {
        SignInText(text = "Nombre:", label = "Introduce tu nombre", placeholder = "Juanito", leadingIcon = Icons.Default.AccountCircle, trailingIcon = Icons.Default.Create)
        Spacer(modifier = Modifier.height(15.dp))
        SignInText(text = "Apellidos:", label = "Introduce tus apellidos", placeholder = "López García", leadingIcon = Icons.Default.Edit, trailingIcon = Icons.Default.Create)
        Spacer(modifier = Modifier.height(15.dp))
        SignInText(text = "Email:", label = "Introduce tu email", placeholder = "tudireccion@server.com", leadingIcon = Icons.Default.Email, trailingIcon = Icons.Default.Create)
        Spacer(modifier = Modifier.height(15.dp))
        SignInText(text = "Teléfono:", label = "Introduce tu número de teléfono", placeholder = "123456789", leadingIcon = Icons.Default.Call, trailingIcon = Icons.Default.Create)
        Spacer(modifier = Modifier.height(15.dp))
        SignInText(text = "Fecha de nacimiento:", label = "Introduce tu fecha de nacimiento", placeholder = "01/01/0001", leadingIcon = Icons.Default.DateRange, trailingIcon = Icons.Default.Create)
        Spacer(modifier = Modifier.height(15.dp))
    }
}
//--------------------------------------------------------------------------------------------------

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInElement() {
    FilterChip(
        selected = true,
        onClick = { /*TODO*/ },
        label = { /*TODO*/ })
}

@Composable
fun SignInElements() {
    
}

//--------------------------------------------------------------------------------------------------

@Composable
fun SignInButton() {
    
}

@Composable
fun SignInButtons() {
    
}

//--------------------------------------------------------------------------------------------------

@Composable
fun SignInInfo() {

}

