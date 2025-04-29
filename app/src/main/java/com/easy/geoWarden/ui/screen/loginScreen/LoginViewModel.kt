package com.easy.geoWarden.ui.screen.loginScreen

import android.content.ContentValues.TAG
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import timber.log.Timber


class LoginViewModel:ViewModel() {
    private lateinit var auth: FirebaseAuth

    fun login(email: String, password: String) {
            auth = Firebase.auth
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    task -> if (task.isSuccessful){
                    Timber.tag("Login").d("Login Success")
                    val user = auth.currentUser

                    }
                    else{
                    Timber.tag(TAG).w(task.exception, "Falha na criação de usuario")}
                }

    }

}