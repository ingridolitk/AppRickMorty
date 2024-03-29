package com.example.myapplication.home.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.myapplication.databinding.ActivityMainBinding
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews(binding)
    }

    private fun initViews(binding: ActivityMainBinding) {
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigation.apply{
            setupWithNavController(navController)
            setOnNavigationItemReselectedListener {  }

        }
    }
}
