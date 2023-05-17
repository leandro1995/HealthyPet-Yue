package com.leandro1995.healthypet

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.leandro1995.healthypet.activity.WelcomeActivity
import com.leandro1995.healthypet.config.Setting
import java.util.concurrent.TimeUnit

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Thread.sleep(TimeUnit.SECONDS.toMillis(Setting.SPLASH_TIME_OUT))

        installSplashScreen().setKeepOnScreenCondition { true }

        startActivity(Intent(this, WelcomeActivity::class.java))
    }
}