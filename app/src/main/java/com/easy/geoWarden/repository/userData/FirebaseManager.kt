package com.easy.geoWarden.repository.userData

import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FirebaseManager {
    val db = Firebase.firestore
    val fire = Firebase.auth

    fun getCurrentUser(): String? {
        return fire.currentUser?.uid
    }

    fun verifyCurrentUser():Boolean{
        return fire.currentUser != null
    }

}