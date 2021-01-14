package com.example.prograce

import com.google.firebase.storage.FirebaseStorage
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val storage = FirebaseStorage.getInstance()
        val storageRef = storage.reference
    }
}