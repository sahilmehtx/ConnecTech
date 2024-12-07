package com.cs407.connectech

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.cs407.connectech.auth.LoginFragment
import com.cs407.connectech.auth.RegisterFragment

class ConnecTechApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_container)

        val loginButton: Button = findViewById(R.id.login_button)
        val createAccountButton: Button = findViewById(R.id.create_account_button)

        loginButton.setOnClickListener {
            navigateToFragment(LoginFragment())
        }

        createAccountButton.setOnClickListener {
            navigateToFragment(RegisterFragment())
        }
    }

    fun navigateToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
