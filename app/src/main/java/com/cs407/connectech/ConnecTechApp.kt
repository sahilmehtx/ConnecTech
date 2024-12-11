package com.cs407.connectech

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.cs407.connectech.ui.main.HomeFragment
import com.cs407.connectech.auth.LoginFragment
import com.cs407.connectech.auth.RegisterFragment
import com.cs407.connectech.ui.main.LandingPage

class ConnecTechApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // Updated to activity_main.xml

        if (savedInstanceState == null) {
            // Load the HomeFragment initially
           // navigateToFragment(landingPage())
        }
    }


    override fun onBackPressed() {
        val navController = findNavController(R.id.nav_host_fragment)
        if (!navController.navigateUp()) {
            super.onBackPressed()
        }
    }
}
