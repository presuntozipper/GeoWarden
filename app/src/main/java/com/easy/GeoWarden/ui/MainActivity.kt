package com.easy.GeoWarden.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import com.easy.GeoWarden.ui.Navigation.NavigationGraph
import timber.log.Timber
import timber.log.Timber.Forest.tag

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())
        tag(TAG).w("INICIALIZADO")
        enableEdgeToEdge()
        setContent{
            NavigationGraph(modifier = Modifier)

        }

    }






}