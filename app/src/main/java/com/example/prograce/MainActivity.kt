package com.example.prograce

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.example.prograce.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

class MainActivity : AppCompatActivity() {

    lateinit var navController : NavController
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Prograce)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.mobile_navigation)

        Firebase.initialize(this)
        if(FirebaseAuth.getInstance().currentUser == null) {
            navGraph.startDestination = R.id.welcomeFragment
        }
        else {
            navGraph.startDestination = R.id.projectsFragment
        }
        navController.graph = navGraph
    }
}