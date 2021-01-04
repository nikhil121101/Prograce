package com.example.prograce

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.prograce.databinding.FragmentWelcomeBinding
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class WelcomeFragment : Fragment() {

    //val db = Firebase.firestore
    private val RC_SIGN_IN = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding =  FragmentWelcomeBinding.inflate(inflater, container, false)

        if(FirebaseAuth.getInstance().currentUser == null) {
            //launch the firebase ui
        }
        else {

        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar!!.show()
    }
}