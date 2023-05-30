package com.leandro1995.healthypet.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var homeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        navigationComponent()
    }

    private fun navigationComponent() {

        homeBinding.bottomNavigationComponent.navigationItem(navController = findNavController(R.id.nav_host_fragment_activity_main))
    }
}