package com.example.prograce

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.example.prograce.databinding.ActivityMainBinding
import com.example.prograce.ui.profile.ProfileViewModel
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

class MainActivity : AppCompatActivity() {

    lateinit var profileViewModel : ProfileViewModel
    lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        setSupportActionBar(findViewById(R.id.toolbar))
        //you always come to this activity when authentication is complete
        Firebase.initialize(this)

        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        binding.profileViewModel = profileViewModel
    }
}