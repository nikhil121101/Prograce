package com.example.prograce

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun f() {
        val db = Firebase.firestore
        val user = hashMapOf(
                "first" to "Ada",
                "last" to "Lovelace",
                "born" to 1815
        )
        // Add a new document with a generated ID
        var x : Int = 0
        db.collection("users")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    println("DocumentSnapshot added with ID: ${documentReference.id}")
                    x = 1
                }
                .addOnFailureListener { e ->
                    println("Error adding document : $e")
                }
        assert(x == 1)
    }
}