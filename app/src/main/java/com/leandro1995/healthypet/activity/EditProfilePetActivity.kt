package com.leandro1995.healthypet.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.config.callback.intent.EditProfilePetIntentCallBack
import com.leandro1995.healthypet.databinding.ActivityEditProfilePetBinding
import com.leandro1995.healthypet.extension.lifecycleScope
import com.leandro1995.healthypet.intent.config.EditProfilePetIntentConfig
import com.leandro1995.healthypet.viewmodel.EditProfilePetViewModel

class EditProfilePetActivity : AppCompatActivity(), EditProfilePetIntentCallBack {

    private lateinit var editProfilePetBinding: ActivityEditProfilePetBinding

    private val editProfilePetViewModel by viewModels<EditProfilePetViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        EditProfilePetIntentConfig.instance(editProfilePetIntentCallBack = this)

        editProfilePetBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_edit_profile_pet)

        editProfilePetBinding.editProfilePetViewModel = editProfilePetViewModel

        collect()
    }

    private fun collect() {

        lifecycleScope(activity = this, method = {

            editProfilePetViewModel.editProfilePetMutableStateFlow.collect { editProfilePetIntent ->

                EditProfilePetIntentConfig.editProfilePetSelect(editProfilePetIntent = editProfilePetIntent)
            }
        })
    }

    override fun view() {
        
    }
}