package com.easy.GeoWarden

import android.content.ContentValues
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import com.easy.GeoWarden.repository.userData.FirebaseManager
import com.easy.GeoWarden.ui.Navigation.NavigationGraph
import timber.log.Timber


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.Forest.plant(Timber.DebugTree())
        Timber.Forest.tag(ContentValues.TAG).w("INICIALIZADO")
        enableEdgeToEdge()
        setContent {
            val firebaseManager = FirebaseManager()

            //firebaseManager.createNewUser("teste@gmail.com")


            NavigationGraph(modifier = Modifier.Companion)

        }

    }






}