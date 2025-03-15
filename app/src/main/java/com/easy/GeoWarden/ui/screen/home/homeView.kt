package com.easy.GeoWarden.ui.screen.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.easy.GeoWarden.ui.screen.home.components.ConfigButton
import kotlinx.serialization.Serializable


class homeView : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "home") {
            }
            HomeView()
        }
    }
}

@Composable
fun HomeView(){
    val navHostController = rememberNavController()
    Box( modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
    ){ Text("Ola")
        ConfigButton().ConfigurationButton()
    }
}
@Serializable
object ConfigurationView