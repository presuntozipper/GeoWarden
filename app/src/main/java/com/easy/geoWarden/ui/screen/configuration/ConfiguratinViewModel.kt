package com.easy.geoWarden.ui.screen.configuration

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class ConfiguratinViewModel:ViewModel() {

    fun check():Boolean{
        val user: FirebaseUser? = FirebaseAuth.getInstance().currentUser
        return if (user == null){
            false
        } else{
            true
        }

    }
    fun navigateToLogin(){

        return
    }


}