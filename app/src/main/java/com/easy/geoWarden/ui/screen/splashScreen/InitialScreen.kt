package com.easy.geoWarden.ui.screen.splashScreen


import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

import com.easy.GeoWarden.R
import kotlinx.coroutines.delay


@Composable
fun InitialScreen(modifier: Modifier = Modifier, onNavigate: () -> Unit){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.iconsplash),
            contentDescription = "App Icon"
        )
        //inserir alguma animação para o splash screen
    }
    LaunchedEffect(key1 = true){
        delay(500)
        onNavigate()
    }



}