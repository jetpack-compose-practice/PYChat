package com.piyushprajpti.pychat.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.piyushprajpti.pychat.R

val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.mulish_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    ),

    headlineSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.mulish_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),

    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.mulish_semibold)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),

    titleSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.mulish_semibold)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.mulish_semibold)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),

    bodyMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.mulish_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp
    ),

    labelLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.mulish_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp
    ),

    labelMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.mulish_semibold)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp
    ),

    labelSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.mulish_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    )
)
