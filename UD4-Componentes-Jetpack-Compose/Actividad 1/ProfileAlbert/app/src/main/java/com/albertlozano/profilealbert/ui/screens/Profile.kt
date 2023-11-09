/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.albertlozano.profilealbert.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.albertlozano.profilealbert.R

/**
 * @Composable that contains all the screen's components.
 * Conformed by a main Column, composed of Rows, and inside of every row, there's a custom @Composable that consists of a group of predefined @Composables.
 */
@Composable
fun Profile() {
    // Main column with all the rows.
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.aquamarine1)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Row for presentation part.
        Row {
            ProfilePresentation(
                profilePicture = painterResource(id = R.drawable.profilepic),
                profilePictureDescription = stringResource(id = R.string.altProfilePic),
                profileName = stringResource(id = R.string.profileName),
                buttonText = stringResource(id = R.string.followButton)
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        // Row for hobbies part.
        Row {
            ProfileHobbies()
        }

        Spacer(modifier = Modifier.height(25.dp))

        // Row for profile photos.
        Row {
            ProfilePhotos()
        }

        Spacer(modifier = Modifier.height(100.dp))

        // Row for mail messages.
        Row {
            ProfileMessages(icon = Icons.Default.Mail, iconDescription = stringResource(id = R.string.altIcon7),buttonText = stringResource(id = R.string.addMessage))
        }
    }
}

//--------------------------------------------------------------------------------------------------

/**
 * Custom @Composable ProfilePresentation.
 * Contains a profile's picture, profile's name and a follow button.
 */
@Composable
fun ProfilePresentation(
    profilePicture: Painter,
    profilePictureDescription: String,
    profileName: String,
    buttonText: String
) {
    // Variables to work with pressed and not pressed buttons.
    var followed by rememberSaveable { mutableStateOf(false) }
    val followText = if (followed) stringResource(id = R.string.unfollowButton) else buttonText
    val followButtonColor = if (followed) colorResource(id = R.color.aquamarine4) else colorResource(id = R.color.white)
    val followTextColor = if (followed) colorResource(id = R.color.white) else colorResource(id = R.color.black)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = profilePicture,
            contentDescription = profilePictureDescription,
            modifier = Modifier
                .clip(CircleShape)
                .size(125.dp)
                .border(
                    width = 3.dp,
                    color = colorResource(id = R.color.aquamarine4),
                    shape = CircleShape
                )
                .height(100.dp)
                .width(100.dp),
            contentScale = ContentScale.Crop
        )
    }

    Spacer(modifier = Modifier.width(15.dp))

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = profileName,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(5.dp))

        Button(
            colors = ButtonDefaults.buttonColors(followButtonColor),
            onClick = {
                followed = !followed
            }
        ) {
            Text(
                text = followText,
                color = followTextColor
            )
        }
    }
}

//--------------------------------------------------------------------------------------------------

/**
 * Custom @Composable ProfileHobbies.
 * Contains an Icon and a hobby description of the user's profile.
 */
@Composable
fun ProfileHobby(icon: ImageVector, iconDescription: String, hobby: String) {
    Row {
        Icon(
            imageVector = icon,
            contentDescription = iconDescription,
            tint = colorResource(id = R.color.aquamarine4)
        )

        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = hobby
        )
    }
}

/**
 * Custom @Composable ProfileHobbies.
 * Contains a series of hobbies.
 */
@Composable
fun ProfileHobbies() {
    // Calling ProfileHobby @Composable multiple times.
    Column {
        ProfileHobby(
            icon = Icons.Default.VideogameAsset,
            iconDescription = stringResource(id = R.string.altIcon1),
            hobby = stringResource(id = R.string.hobby1)
        )
        ProfileHobby(
            icon = Icons.Default.SportsBasketball,
            iconDescription = stringResource(id = R.string.altIcon2),
            hobby = stringResource(id = R.string.hobby2)
        )
        ProfileHobby(
            icon = Icons.Default.FormatPaint,
            iconDescription = stringResource(id = R.string.altIcon3),
            hobby = stringResource(id = R.string.hobby3)
        )
        ProfileHobby(
            icon = Icons.Default.Draw,
            iconDescription = stringResource(id = R.string.altIcon4),
            hobby = stringResource(id = R.string.hobby4)
        )
        ProfileHobby(
            icon = Icons.Default.Keyboard,
            iconDescription = stringResource(id = R.string.altIcon5),
            hobby = stringResource(id = R.string.hobby5)
        )
    }
}

//--------------------------------------------------------------------------------------------------

/**
 * Custom @Composable ProfileImages.
 * Contains an Image (pretended to be published by the user's profile), plus an Icon to indicate if it is liked or not.
 */
@Composable
fun ProfilePhoto(
    photo: Painter,
    photoDescription: String,
    icon: ImageVector,
    iconDescription: String
) {
    // Variables to work with pressed and not pressed buttons.
    var isLiked by rememberSaveable { mutableStateOf(false) }
    val likedButtonColor = if (isLiked) colorResource(id = R.color.aquamarine4) else colorResource(id = R.color.white)
    val likedIconColor = if (isLiked) colorResource(id = R.color.white) else colorResource(id = R.color.aquamarine4)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = photo,
            contentDescription = photoDescription,
            modifier = Modifier
                .clip(RectangleShape)
                .size(175.dp)
                .border(
                    width = 3.dp,
                    color = colorResource(id = R.color.aquamarine3),
                    shape = RectangleShape
                )
                .height(100.dp)
                .width(100.dp),
            contentScale = ContentScale.Crop
        )

        Button(
            colors = ButtonDefaults.buttonColors(likedButtonColor),
            onClick = {
                isLiked = !isLiked
            }
        ) {
            Icon(
                imageVector = icon,
                contentDescription = iconDescription,
                tint = likedIconColor
            )
        }
    }
}

/**
 * Custom @Composable ProfileImages.
 * Contains two Images (pretended to be published by the user's profile), plus two heart Icons to indicate if they are liked or not.
 */
@Composable
fun ProfilePhotos() {
    // Calling ProfilePhoto @Composables 2 times.
    ProfilePhoto(
        photo = painterResource(id = R.drawable.image1),
        photoDescription = stringResource(id = R.string.altImage1),
        icon = Icons.Default.ThumbUp,
        iconDescription = stringResource(id = R.string.altIcon6)
    )

    Spacer(modifier = Modifier.width(25.dp))

    ProfilePhoto(
        photo = painterResource(id = R.drawable.image2),
        photoDescription = stringResource(id = R.string.altImage2),
        icon = Icons.Default.ThumbUp,
        iconDescription = stringResource(id = R.string.altIcon6)
    )
}

//--------------------------------------------------------------------------------------------------

/**
 * Custom @Composable ProfileMessages.
 * Contains a BadgedBox and a Button that depict the user's messages.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileMessages(icon: ImageVector, iconDescription: String, buttonText: String) {
    // Variable to work with the number of messages received.
    var numMessages by rememberSaveable { mutableStateOf(0) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BadgedBox(
            badge = {
                Badge {
                    Text(text = "$numMessages")
                }
            }
        ) {
            Icon(
                icon,
                contentDescription = iconDescription
            )
        }

        Spacer(modifier = Modifier.height(5.dp))

        Button(
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.aquamarine4)),
            onClick = {
                numMessages++
            }
        ) {
            Text(text = buttonText)
        }
    }
}
