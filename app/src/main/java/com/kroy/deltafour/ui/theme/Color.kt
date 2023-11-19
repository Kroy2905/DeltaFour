package com.kroy.deltafour.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val appColor = Color(0xFF2196F3)
val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
val ExpandableTint = Color(0xFFF9FDFF)
// Define a custom color using an extension function
fun Color.Companion.appColor(): Color {
    // You can specify the color using RGBA values
    return  appColor
}
