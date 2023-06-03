package com.leandro1995.healthypet.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.databinding.ActivityRegisterInjectionBinding

class RegisterInjectionActivity : AppCompatActivity() {

    private lateinit var registerInjectionBinding: ActivityRegisterInjectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        registerInjectionBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_register_injection)
    }
}