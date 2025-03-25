package com.easy.GeoWarden.repository.userData

import android.content.ContentValues.TAG
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import timber.log.Timber

class FirebaseManager {
    val db = Firebase.firestore


    fun createNewUser(email: String) {
        Timber.plant(Timber.DebugTree())
        val user = hashMapOf(
            "email" to email
        )
        db.collection("Usuarios").add(user)
            .addOnSuccessListener { documentReference ->
                Timber.tag(TAG).d("DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Timber.tag(TAG).w("Error adding document: $e")
            }

    }




}