package com.leandro1995.healthypet.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.config.callback.intent.WelcomeIntentCallBack
import com.leandro1995.healthypet.databinding.ActivityWelcomeBinding
import com.leandro1995.healthypet.extension.lifecycleScope
import com.leandro1995.healthypet.intent.config.WelcomeIntentConfig
import com.leandro1995.healthypet.viewmodel.WelcomeViewModel

class WelcomeActivity : AppCompatActivity(), WelcomeIntentCallBack {

    private lateinit var welcomeBinding: ActivityWelcomeBinding

    private val welcomeViewModel by viewModels<WelcomeViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WelcomeIntentConfig.instance(welcomeIntentCallBack = this)

        welcomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_welcome)
        welcomeBinding.welcomeViewModel = welcomeViewModel

        collect()
    }

    private fun collect() {

        lifecycleScope(activity = this, method = {

            welcomeViewModel.welComeMutableStateFlow.collect { welcomeIntent ->

                WelcomeIntentConfig.welcomeSelect(welcomeIntent = welcomeIntent)
            }
        })
    }

    override fun view() {

    }
}