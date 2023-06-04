package com.leandro1995.healthypet.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.databinding.ActivityRegisterInjectionBinding
import com.leandro1995.healthypet.util.DesignUtil

class RegisterInjectionActivity : AppCompatActivity() {

    private lateinit var registerInjectionBinding: ActivityRegisterInjectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        registerInjectionBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_register_injection)

        materialToolbar()
    }

    private fun materialToolbar() {

        DesignUtil.materialToolbar(activity = this,
            materialToolbar = registerInjectionBinding.appBar.toolbar,
            idTitle = R.string.register_injection_text_title,
            isArrow = true,
            method = { finish() })
    }
}