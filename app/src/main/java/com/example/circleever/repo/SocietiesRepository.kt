package com.example.circleever.repo

import com.example.circleever.OnError
import com.example.circleever.OnSuccess
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

class SocietiesRepository {

    private val firestore = FirebaseFirestore.getInstance()

    fun getSocietiesDetails() = callbackFlow {

        val collection = firestore.collection("SocietyDetails")
        val snapshotListner = collection.addSnapshotListener{ value, error ->
            val response = if (error == null) {
                OnSuccess(value)
            } else {
                OnError(error)
            }

            trySend(response)

        }

        awaitClose{
            snapshotListner.remove()
        }

    }

}