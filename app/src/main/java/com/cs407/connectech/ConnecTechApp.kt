package com.cs407.connectech

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class ConnecTechApp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Retrieve the NavHostFragment and its NavController
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Initialize BottomNavigationView and set it up with NavController
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        NavigationUI.setupWithNavController(bottomNav, navController)

        // Add listener to handle destination changes and manage bottom navigation visibility
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.loginFragment,
                R.id.registerFragment,
                R.id.landingPage,
                R.id.forgotPasswordFragment -> { // Add forgotPasswordFragment here
                    // Hide BottomNavigationView for specific fragments
                    bottomNav.visibility = View.GONE
                }
                else -> {
                    // Show BottomNavigationView for all other fragments
                    bottomNav.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onBackPressed() {
        // Handle back navigation using the NavController
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Navigate up in the NavController stack, or fallback to default behavior
        if (!navController.navigateUp()) {
            super.onBackPressed()
        }
    }
}
