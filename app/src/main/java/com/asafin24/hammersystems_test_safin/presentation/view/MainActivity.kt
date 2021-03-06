package com.asafin24.hammersystems_test_safin.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.asafin24.hammersystems_test_safin.APP
import com.asafin24.hammersystems_test_safin.R
import com.asafin24.hammersystems_test_safin.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    private var navHostFragment: NavHostFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        APP = this

        navHostFragment = supportFragmentManager.findFragmentById(R.id.mainNavHostFragment) as? NavHostFragment ?: return
        navController = findNavController(R.id.mainNavHostFragment)

        val mainBottomNavView = findViewById<BottomNavigationView>(R.id.mainBottomNavView)
        mainBottomNavView.setupWithNavController(navController)
    }

}