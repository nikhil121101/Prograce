package com.example.prograce.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class ProfileViewModel : ViewModel() {

    private val _curUser = MutableLiveData<FirebaseUser>()
    val curUser : LiveData<FirebaseUser> = _curUser

    init {
        refreshUser()
    }

    fun refreshUser() {
        _curUser.value = FirebaseAuth.getInstance().currentUser
    }

}