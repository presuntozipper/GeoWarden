package com.easy.GeoWarden.ui.screen.configuration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class configurationView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                ConfigurationView()

            }
        }
}

@Composable
fun ConfigurationView(){
    Box( modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text("Tela de configurações")
    }

}

