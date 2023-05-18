package com.leandro1995.healthypet.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.databinding.ActivityWelcomeBinding
import com.leandro1995.healthypet.viewmodel.WelcomeViewModel

class WelcomeActivity : AppCompatActivity() {

    private lateinit var welcomeBinding: ActivityWelcomeBinding

    private val welcomeViewModel by viewModels<WelcomeViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        welcomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_welcome)
        welcomeBinding.welcomeViewModel = welcomeViewModel
    }
}