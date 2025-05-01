package com.easy.geoWarden.ui.Theme.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


val GradientColorBlueToBlack = Brush.linearGradient(
    colors = listOf(Color.Blue, Color.Black),
    start = androidx.compose.ui.geometry.Offset(150f, 60f),
    end = androidx.compose.ui.geometry.Offset(2000f, 3000f)
)
val GradientColorLightBlueToDarkBlue = Brush.linearGradient(
    colors = listOf(Color(0xFF2561FF), Color(0xFF062A63)),
    start = androidx.compose.ui.geometry.Offset(150f, 60f),
    end = androidx.compose.ui.geometry.Offset(980f, 3000f)

)




val GradientColorLightBlueToDarkBlue2 = Brush.linearGradient(
    colors = listOf(Color(0xFF1A237E), Color(0xFF2561FF)),
    start = androidx.compose.ui.geometry.Offset(200f, 102f),
    end = androidx.compose.ui.geometry.Offset(80f, 160f)
)
val GradientColorLightBlueToDarkBlue3 = Brush.linearGradient(
    colors = listOf(Color(0xFF182755), Color(0xFF1A237E)),
    start = androidx.compose.ui.geometry.Offset(200f, 102f),
    end = androidx.compose.ui.geometry.Offset(20f, 160f)
)

@Composable
fun SetBackground() {
    Box(modifier = Modifier.fillMaxSize()
        .background(brush = GradientColorLightBlueToDarkBlue2))
    {  }
}



val MarineBlue = Color(0xFF142236)
val LightMarine = Color(0xFF07224a)
val Pink80 = Color(0xFF133C90)
val Black = Color(0xFF000000)

val Purple40 = Color(0xFFB7F5F5)
val PurpleGrey40 = Color(0xFFFEFCFF)
val Pink40 = Color(0xFFFFFBFC)

val WhiteColor = Color(0xFFFFFFFF)
val Green = Color(0xFF0DE03B)
val Red = Color(0xFFFF0000)
val DarkGrayBlue = Color(0xFF514B6A)
val LightGrayGreen = Color(0xFF5C6661)
val LightGray = Color(0xFFA09D9D)

@Preview
@Composable
fun GradientPreview() {
    SetBackground()
}