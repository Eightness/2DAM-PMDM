/**
 * @author Albert Lozano Blasco
 * @version 2.0
 */

package com.albertlozano.signinalbert.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.albertlozano.signinalbert.R

//MAIN FUNCTION
//--------------------------------------------------------------------------------------------------

/**
 * Function SignIn. Main function that contains all customized UI components.
 */
@Composable
fun SignIn() {
    //----------------------------------------------------------------------------------------------

    //Variable to save Vertical Scroll state
    val scrollState = rememberScrollState()

    //Data variables
    var name by rememberSaveable { mutableStateOf("") }
    var surnames by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    var birthDate by rememberSaveable { mutableStateOf("") }

    //Interests variables
    var selectedItemsList by rememberSaveable { mutableStateOf(List(6) { false }) }

    val videoGames =
        if (selectedItemsList[0]) stringResource(id = R.string.interested) else stringResource(id = R.string.notInterested)
    val sports =
        if (selectedItemsList[1]) stringResource(id = R.string.interested) else stringResource(id = R.string.notInterested)
    val series =
        if (selectedItemsList[2]) stringResource(id = R.string.interested) else stringResource(id = R.string.notInterested)
    val cinema =
        if (selectedItemsList[3]) stringResource(id = R.string.interested) else stringResource(id = R.string.notInterested)
    val coding =
        if (selectedItemsList[4]) stringResource(id = R.string.interested) else stringResource(id = R.string.notInterested)
    val boardGames =
        if (selectedItemsList[5]) stringResource(id = R.string.interested) else stringResource(id = R.string.notInterested)

    //Variables to control the state of Alert Dialog
    var showDialog by rememberSaveable { mutableStateOf(false) }
    val correctData = validateData(name, surnames, email, phoneNumber, birthDate)

    val titleMessage =
        if (correctData) stringResource(id = R.string.sentInfo) else stringResource(id = R.string.notSent)
    val dialogMessageCorrect = if (correctData) {
        """|${stringResource(id = R.string.personalData)}
            |${stringResource(id = R.string.name)}: $name
            |${stringResource(id = R.string.surnames)}: $surnames
            |${stringResource(id = R.string.email)}: $email
            |${stringResource(id = R.string.phoneNumber)}: $phoneNumber
            |${stringResource(id = R.string.birthDate)}: $birthDate
            |
            |${stringResource(id = R.string.interests)}
            |${stringResource(id = R.string.videogames)}: $videoGames
            |${stringResource(id = R.string.sports)}: $sports
            |${stringResource(id = R.string.series)}: $series
            |${stringResource(id = R.string.cinema)}: $cinema
            |${stringResource(id = R.string.coding)}: $coding
            |${stringResource(id = R.string.boardGames)}: $boardGames
    
        """.trimMargin("|")
    } else stringResource(id = R.string.incorrectData)

    //----------------------------------------------------------------------------------------------

    //Main Column
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
            .padding(20.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //------------------------------------------------------------------------------------------

        //Personal data
        Text(
            text = stringResource(id = R.string.personalData),
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.delftBlue)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomDataField(textFieldValue = name,
                    label = stringResource(id = R.string.name),
                    placeholder = stringResource(id = R.string.namePlaceholder),
                    leadingIcon = Icons.Default.AccountCircle,
                    trailingIcon = Icons.Default.Create,
                    onValueChanged = { name = it })
                Spacer(modifier = Modifier.height(15.dp))
                CustomDataField(textFieldValue = surnames,
                    label = stringResource(id = R.string.surnames),
                    placeholder = stringResource(id = R.string.surnamesPlaceholder),
                    leadingIcon = Icons.Default.Info,
                    trailingIcon = Icons.Default.Create,
                    onValueChanged = { surnames = it })
                Spacer(modifier = Modifier.height(15.dp))
                CustomDataField(textFieldValue = email,
                    label = stringResource(id = R.string.email),
                    placeholder = stringResource(id = R.string.emailPlaceholder),
                    leadingIcon = Icons.Default.Email,
                    trailingIcon = Icons.Default.Create,
                    onValueChanged = { email = it })
                Spacer(modifier = Modifier.height(15.dp))
                CustomDataField(textFieldValue = phoneNumber,
                    label = stringResource(id = R.string.phoneNumber),
                    placeholder = stringResource(id = R.string.phoneNumberPlaceHolder),
                    leadingIcon = Icons.Default.Call,
                    trailingIcon = Icons.Default.Create,
                    onValueChanged = { phoneNumber = it })
                Spacer(modifier = Modifier.height(15.dp))
                CustomDataField(textFieldValue = birthDate,
                    label = stringResource(id = R.string.birthDate),
                    placeholder = stringResource(id = R.string.birthDatePlaceholder),
                    leadingIcon = Icons.Default.DateRange,
                    trailingIcon = Icons.Default.Create,
                    onValueChanged = { birthDate = it })
                Spacer(modifier = Modifier.height(15.dp))
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        //------------------------------------------------------------------------------------------

        //Interests
        Text(
            text = stringResource(id = R.string.interests),
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.delftBlue)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    CustomInterest(interestName = stringResource(id = R.string.videogames),
                        leadingIcon = Icons.Default.Done,
                        isSelected = selectedItemsList[0],
                        onClick = {
                            selectedItemsList = selectedItemsList.toMutableList()
                                .apply { set(0, !selectedItemsList[0]) }
                        })

                    Spacer(modifier = Modifier.width(10.dp))

                    CustomInterest(interestName = stringResource(id = R.string.sports),
                        leadingIcon = Icons.Default.Done,
                        isSelected = selectedItemsList[1],
                        onClick = {
                            selectedItemsList = selectedItemsList.toMutableList()
                                .apply { set(1, !selectedItemsList[1]) }
                        })

                    Spacer(modifier = Modifier.width(10.dp))

                    CustomInterest(interestName = stringResource(id = R.string.series),
                        leadingIcon = Icons.Default.Done,
                        isSelected = selectedItemsList[2],
                        onClick = {
                            selectedItemsList = selectedItemsList.toMutableList()
                                .apply { set(2, !selectedItemsList[2]) }
                        })
                }

                Row {
                    CustomInterest(interestName = stringResource(id = R.string.cinema),
                        leadingIcon = Icons.Default.Done,
                        isSelected = selectedItemsList[3],
                        onClick = {
                            selectedItemsList = selectedItemsList.toMutableList()
                                .apply { set(3, !selectedItemsList[3]) }
                        })

                    Spacer(modifier = Modifier.width(10.dp))

                    CustomInterest(interestName = stringResource(id = R.string.coding),
                        leadingIcon = Icons.Default.Done,
                        isSelected = selectedItemsList[4],
                        onClick = {
                            selectedItemsList = selectedItemsList.toMutableList()
                                .apply { set(4, !selectedItemsList[4]) }
                        })

                    Spacer(modifier = Modifier.width(10.dp))

                    CustomInterest(interestName = stringResource(id = R.string.videogames),
                        leadingIcon = Icons.Default.Done,
                        isSelected = selectedItemsList[5],
                        onClick = {
                            selectedItemsList = selectedItemsList.toMutableList()
                                .apply { set(5, !selectedItemsList[5]) }
                        })
                }
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        //------------------------------------------------------------------------------------------

        //Buttons
        Row {
            Row {
                //Reset button
                Button(colors = ButtonDefaults.buttonColors(colorResource(id = R.color.delftBlue)),
                    onClick = {
                        name = ""
                        surnames = ""
                        email = ""
                        phoneNumber = ""
                        birthDate = ""
                        selectedItemsList = selectedItemsList.toMutableList().apply {
                            fill(false)
                        }
                    }) {
                    Text(
                        text = stringResource(id = R.string.resetButton)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                //Send button
                Button(colors = ButtonDefaults.buttonColors(colorResource(id = R.color.delftBlue)),
                    onClick = {
                        showDialog = true
                    }) {
                    Text(
                        text = stringResource(id = R.string.sendButton)
                    )
                }
            }
            if (showDialog) {
                AlertDialog(onDismissRequest = {
                    //Callback when the Alert Dialog is dismissed
                    showDialog = false
                }, title = {
                    //Display the title message
                    Text(text = titleMessage)
                }, text = {
                    //Display the main content message
                    Text(
                        text = dialogMessageCorrect
                    )
                }, confirmButton = {
                    //OK button to close the Alert Dialog
                    Button(onClick = {
                        // Callback when the OK button is clicked
                        showDialog = false
                    }) {
                        Text(text = "OK")
                    }
                })
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        //------------------------------------------------------------------------------------------

        //Author Info
        Row {
            CustomAuthorInfo(
                painterResource(id = R.drawable.profilepic),
                stringResource(id = R.string.appMadeBy),
                stringResource(id = R.string.author)
            )
        }
    }
}

//CUSTOM COMPONENTS
//--------------------------------------------------------------------------------------------------

/**
 * Function CustomDataField. Contains an icon and an OutlinedTextField, allowing user interaction.
 *
 * @param textFieldValue The current value of the text field.
 * @param label The label or prompt for the text field.
 * @param placeholder The placeholder text displayed in the text field when empty.
 * @param leadingIcon The leading icon displayed before the text field.
 * @param trailingIcon The trailing icon displayed after the text field.
 * @param onValueChanged A callback function triggered when the value of the text field changes.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDataField(
    textFieldValue: String,
    label: String,
    placeholder: String,
    leadingIcon: ImageVector,
    trailingIcon: ImageVector,
    onValueChanged: (String) -> Unit
) {
    Row {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Add spacing for visual separation
            Spacer(modifier = Modifier.height(24.dp))
            //Display the leading icon
            Icon(
                imageVector = leadingIcon,
                contentDescription = null,
                tint = colorResource(id = R.color.delftBlue)
            )
        }

        //Add horizontal spacing between the icon and text field
        Spacer(modifier = Modifier.width(25.dp))

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Create the OutlinedTextField with specified parameters
            OutlinedTextField(value = textFieldValue, onValueChange = {
                onValueChanged(it)
            }, label = {
                Text(
                    text = label, color = colorResource(id = R.color.uclaBlue)
                )
            }, placeholder = {
                Text(
                    text = placeholder, color = colorResource(id = R.color.powderBlue)
                )
            }, trailingIcon = {
                //Display the trailing icon
                Icon(
                    imageVector = trailingIcon,
                    contentDescription = null,
                    tint = colorResource(id = R.color.bluedGrey)
                )
            })
        }
    }
}

//--------------------------------------------------------------------------------------------------

/**
 * Function CustomInterest. Contains an ElevatedFilterChip, allowing the user to select an interest.
 *
 * @param interestName The name or label of the interest.
 * @param leadingIcon The icon associated with the interest.
 * @param isSelected A boolean indicating whether the interest is currently selected.
 * @param onClick A callback function triggered when the filter chip is clicked.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomInterest(
    interestName: String,
    leadingIcon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    //Create an ElevatedFilterChip with specified parameters
    ElevatedFilterChip(selected = isSelected,
        onClick = onClick,
        label = { Text(text = interestName) },
        leadingIcon = {
            //Display the leading icon when the interest is selected
            if (isSelected) {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = null,
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        })
}

//--------------------------------------------------------------------------------------------------

/**
 * Function CustomAuthorInfo. Contains a picture and text depicting the app's author information.
 *
 * @param authorPic The image of the app's author.
 * @param authorName The name of the app's author.
 * @param appMadeBy The text indicating the creator or source of the app.
 */
@Composable
fun CustomAuthorInfo(
    authorPic: Painter,
    authorName: String,
    appMadeBy: String
) {
    //Column containing the author's image
    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display the author's image
        Image(
            painter = authorPic,
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .height(50.dp)
                .width(50.dp),
            contentScale = ContentScale.Crop
        )
    }

    //Add some spacing
    Spacer(modifier = Modifier.width(10.dp))

    //Column containing author information text
    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(3.dp))
        //Display the text indicating who made the app
        Text(
            text = authorName, fontSize = 15.sp
        )
        //Display the author's name
        Text(
            text = appMadeBy, fontSize = 15.sp, fontWeight = FontWeight.Bold
        )
    }
}


//UTILITY
//--------------------------------------------------------------------------------------------------

/**
 * Function validateData. Validates all user's data.
 *
 * @param name The user's name to be validated.
 * @param surnames The user's surnames to be validated.
 * @param email The user's email to be validated.
 * @param phoneNumber The user's phone number to be validated.
 * @param birthDate The user's birth date to be validated.
 *
 * @return `true` if all data is valid, `false` otherwise.
 */
fun validateData(
    name: String,
    surnames: String,
    email: String,
    phoneNumber: String,
    birthDate: String
): Boolean {
    //Regular expressions for validation
    val nameRegex = Regex(".+")
    val surnamesRegex = Regex("^[a-zA-Z]+( [a-zA-Z]+)*\$")
    val emailRegex = Regex("^[A-Za-z](.*)(@)(.+)(\\.)(.+)")
    val phoneNumberRegex = Regex("^\\d{9}$")
    val birthDateRegex = Regex("^\\d{2}/\\d{2}/\\d{4}$")

    //Check if each data format is valid
    val isNameFormatValid = name.matches(nameRegex)
    val isSurnameFormatValid = surnames.matches(surnamesRegex)
    val isEmailFormatValid = email.matches(emailRegex)
    val isPhoneNumberFormatValid = phoneNumber.matches(phoneNumberRegex)
    val isBirthDateFormatValid = birthDate.matches(birthDateRegex)

    //Validate the birth date further
    var isBirthDateValid = false

    if (isBirthDateFormatValid) {
        val parts = birthDate.split("/")
        val day = parts[0].toInt()
        val month = parts[1].toInt()
        val year = parts[2].toInt()
        if ((day in 1..31) && (month in 1..12) && (year in 1900..2022)) isBirthDateValid = true
    }

    //Return true if all data is valid, false otherwise
    return isNameFormatValid && isSurnameFormatValid && isEmailFormatValid && isPhoneNumberFormatValid && isBirthDateValid
}
