package com.cs407.connectech

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.cs407.connectech.ui.main.HomeFragment
import com.cs407.connectech.auth.LoginFragment
import com.cs407.connectech.auth.RegisterFragment
import com.cs407.connectech.ui.main.LandingPage
import com.google.android.material.bottomnavigation.BottomNavigationView

class ConnecTechApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // Updated to activity_main.xml

        // Find the NavHostFragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        // Get the NavController
        val navController = navHostFragment.navController

        // Find the BottomNavigationView
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Set up the BottomNavigationView with the NavController
        NavigationUI.setupWithNavController(bottomNav, navController)
    }

    override fun onBackPressed() {
        val navController = (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
        if (!navController.navigateUp()) {
            super.onBackPressed()
        }
    }
}
