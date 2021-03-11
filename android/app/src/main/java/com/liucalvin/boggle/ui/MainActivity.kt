package com.liucalvin.boggle.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.liucalvin.boggle.R
import com.liucalvin.boggle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController by lazy {
            (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
        }

        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.game_menu_item -> navController.navigate(R.id.action_historyFragment_to_gameFragment)
                R.id.history_menu_item -> navController.navigate(R.id.action_gameFragment_to_historyFragment)
            }
            return@setOnNavigationItemSelectedListener true
        }

        binding.bottomNavigationView.setOnNavigationItemReselectedListener {
            return@setOnNavigationItemReselectedListener
        }
    }
}