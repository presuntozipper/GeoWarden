package com.easy.geoWarden


import android.content.ContentValues

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import com.easy.geoWarden.data.user.UserState
import com.easy.geoWarden.ui.Navigation.NavigationGraph
import timber.log.Timber



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.Forest.plant(Timber.DebugTree())
        Timber.Forest.tag(ContentValues.TAG).w("INICIALIZADO \n" +
                "USER_STATE-: ${UserState.UserSession}")
        enableEdgeToEdge()
        setContent {

            NavigationGraph(modifier = Modifier.Companion)

        }

    }






}