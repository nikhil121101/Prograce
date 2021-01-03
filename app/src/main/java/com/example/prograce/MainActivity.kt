package com.example.prograce

import android.os.Bundle
import android.view.Menu
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

        //        val navHostFragment =
        //                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        //        val navController = navHostFragment.navController
        //        NavigationUI.setupActionBarWithNavController(this, navController)
        setSupportActionBar(findViewById(R.id.toolBar))

    }


}