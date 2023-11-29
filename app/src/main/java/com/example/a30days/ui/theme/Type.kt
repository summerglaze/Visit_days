package com.example.a30days.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.a30days.R

val LibreBaskRegular = FontFamily(
    Font(R.font.librebaskerville_regular)
)

val LibreBaskBold = FontFamily(
    Font(R.font.librebaskerville_bold, FontWeight.Bold)
)

val LibreBaskItalic = FontFamily(
    Font(R.font.librebaskerville_italic, FontWeight.Normal, FontStyle.Italic)
)

val AbrilFatFace = FontFamily(
    Font(R.font.abrilfatface_regular)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = LibreBaskRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    titleLarge = TextStyle(
        fontFamily = LibreBaskBold,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    labelLarge = TextStyle(
        fontFamily = AbrilFatFace,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    labelSmall = TextStyle(
        fontFamily = LibreBaskItalic,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Italic,
        fontSize = 16.sp
    )
)