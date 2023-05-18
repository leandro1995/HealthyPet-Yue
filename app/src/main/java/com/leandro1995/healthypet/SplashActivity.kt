package com.leandro1995.healthypet

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.datastore.config.HealthyPetDataStoreConfig
import com.leandro1995.healthypet.util.DesignUtil
import java.util.concurrent.TimeUnit

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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