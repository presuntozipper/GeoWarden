package com.easy.GeoWarden.ui.screen.loginScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.easy.GeoWarden.ui.Theme.theme.GeoWardenTheme
import com.easy.GeoWarden.ui.Theme.theme.GradientColorBlueToBlack


@Composable
    fun LoginView(function: () -> Unit) {

            GeoWardenTheme {
            Box(modifier = Modifier.fillMaxSize(1f).background(brush = GradientColorBlueToBlack)){

            }
        }

    }

@Preview(showBackground = true)
        @Composable
    fun  PreviewLogin() {
        LoginView {}
        }
