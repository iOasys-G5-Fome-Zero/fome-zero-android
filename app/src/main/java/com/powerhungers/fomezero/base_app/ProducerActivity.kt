package com.powerhungers.fomezero.base_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.powerhungers.fomezero.R

class ProducerActivity : AppCompatActivity() {

    private lateinit var navButton: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producer)

        navButton = findViewById(R.id.bottom_navigation_producer)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_home) as NavHostFragment
        val navController = navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.bottom_navigation_producer)
            .setupWithNavController(navController)
    }
}