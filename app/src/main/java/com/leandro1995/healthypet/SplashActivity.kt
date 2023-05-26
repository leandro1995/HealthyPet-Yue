package com.leandro1995.healthypet

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.config.callback.intent.SplashIntentCallBack
import com.leandro1995.healthypet.datastore.config.HealthyPetDataStoreConfig
import com.leandro1995.healthypet.extension.lifecycleScope
import com.leandro1995.healthypet.intent.config.SplashIntentConfig
import com.leandro1995.healthypet.util.DesignUtil
import com.leandro1995.healthypet.viewmodel.SplashViewModel
import java.util.concurrent.TimeUnit

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity(), SplashIntentCallBack {

    private val splashViewModel by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SplashIntentConfig.instance(splashIntentCallBack = this)

        collect()
    }

    private fun collect() {

        lifecycleScope(activity = this, method = {

            splashViewModel.splashMutableStateFlow.collect { splashIntent ->

                SplashIntentConfig.splashSelect(splashIntent = splashIntent)
            }
        })
    }

    override fun view() {

        Thread.sleep(TimeUnit.SECONDS.toMillis(Setting.SPLASH_TIME_OUT))

        installSplashScreen().setKeepOnScreenCondition { true }

        startActivity(
            Intent(
                this,
                DesignUtil.splashActivitySelect(isWelcome = HealthyPetDataStoreConfig.isWelcome())::class.java
            )
        )
        finishAffinity()
    }
}