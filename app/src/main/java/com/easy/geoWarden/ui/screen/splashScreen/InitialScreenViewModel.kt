package com.easy.geoWarden.ui.screen.splashScreen

import androidx.lifecycle.ViewModel
import com.easy.geoWarden.repository.userData.FirebaseManager

class InitialScreenViewModel:ViewModel() {
    val fire:FirebaseManager = FirebaseManager()

    fun checkUser(){
        if (fire.verifyCurrentUser()){

        }

    }
}