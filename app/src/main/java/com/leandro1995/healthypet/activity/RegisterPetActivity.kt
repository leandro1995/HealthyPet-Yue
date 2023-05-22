package com.leandro1995.healthypet.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.adapter.SpiceAdapter
import com.leandro1995.healthypet.config.callback.intent.RegisterPetIntentCallBack
import com.leandro1995.healthypet.databinding.ActivityRegisterPetBinding
import com.leandro1995.healthypet.extension.lifecycleScope
import com.leandro1995.healthypet.intent.config.RegisterPetIntentConfig
import com.leandro1995.healthypet.util.ArrayListUtil
import com.leandro1995.healthypet.util.DesignUtil
import com.leandro1995.healthypet.viewmodel.RegisterPetViewModel

class RegisterPetActivity : AppCompatActivity(), RegisterPetIntentCallBack {

    private lateinit var registerPetBinding: ActivityRegisterPetBinding

    private val registerPetViewModel by viewModels<RegisterPetViewModel>()

    private lateinit var spiceAdapter: SpiceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        RegisterPetIntentConfig.instance(registerPetIntentCallBack = this)

        registerPetBinding = DataBindingUtil.setContentView(this, R.layout.activity_register_pet)
        registerPetBinding.registerPetViewModel = registerPetViewModel

        materialToolbar()
        collect()
    }

    private fun collect() {

        lifecycleScope(activity = this, method = {

            registerPetViewModel.registerPetMutableStateFlow.collect { registerPetIntent ->

                RegisterPetIntentConfig.registerPetSelect(registerPetIntent = registerPetIntent)
            }
        })
    }

    private fun materialToolbar() {

        DesignUtil.materialToolbar(activity = this,
            materialToolbar = registerPetBinding.appBar.toolbar,
            idTitle = R.string.register_pet_text_title,
            isArrow = true,
            method = { finish() })
    }

    override fun view() {

        spiceAdapter = SpiceAdapter(
            activity = this, spiceArrayList = ArrayListUtil.spiceArrayList()
        )

        registerPetBinding.apply {

            spiceSpinner.adapter = spiceAdapter
        }
    }
}