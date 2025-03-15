package com.easy.GeoWarden.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.easy.GeoWarden.R
import com.easy.GeoWarden.ui.screen.home.HomeView
import kotlinx.coroutines.delay
import timber.log.Timber
import timber.log.Timber.Forest.tag

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())
        tag(TAG).w("")
        enableEdgeToEdge()
        setContent{
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "") { }

            Navigate()
        }

    }

    @Composable
    fun Navigate(){
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "splash")
        {
            composable(route = "splash"){InitialScreen(navController)}
            composable(route = "home"){ HomeView() }
        }
    }



    @Composable
    fun InitialScreen(navController: NavHostController) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.iconsplash),
                contentDescription = "App Icon"
            )
        }
        LaunchedEffect(key1 = true) { delay(5000) }
        navController.navigate("home") {
            popUpTo("splash") { inclusive = true }
        }


    }




}