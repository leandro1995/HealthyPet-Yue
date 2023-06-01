package com.leandro1995.healthypet.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.adapter.SpiceAdapter
import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.config.callback.intent.EditProfilePetIntentCallBack
import com.leandro1995.healthypet.config.callback.spinner.SpiceSpinnerCallBack
import com.leandro1995.healthypet.config.listener.SpiceSpinnerListener
import com.leandro1995.healthypet.databinding.ActivityEditProfilePetBinding
import com.leandro1995.healthypet.extension.lifecycleScope
import com.leandro1995.healthypet.extension.putPet
import com.leandro1995.healthypet.intent.config.EditProfilePetIntentConfig
import com.leandro1995.healthypet.model.entity.Spice
import com.leandro1995.healthypet.util.ArrayListUtil
import com.leandro1995.healthypet.util.DesignUtil
import com.leandro1995.healthypet.viewmodel.EditProfilePetViewModel

class EditProfilePetActivity : AppCompatActivity(), EditProfilePetIntentCallBack {

    private lateinit var editProfilePetBinding: ActivityEditProfilePetBinding

    private val editProfilePetViewModel by viewModels<EditProfilePetViewModel>()

    private lateinit var spiceAdapter: SpiceAdapter

    private val spiceArrayList = arrayListOf<Spice>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        EditProfilePetIntentConfig.instance(editProfilePetIntentCallBack = this)

        editProfilePetBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_edit_profile_pet)

        editProfilePetBinding.editProfilePetViewModel = editProfilePetViewModel

        putExtra()
        materialToolbar()
        collect()
    }

    private fun putExtra() {

        editProfilePetViewModel.pet = (Setting.PET_PUT putPet this)!!
    }

    private fun materialToolbar() {

        DesignUtil.materialToolbar(activity = this,
            materialToolbar = editProfilePetBinding.appBar.toolbar,
            idTitle = R.string.edit_pet_text_title,
            isArrow = true,
            method = { finish() })
    }

    private fun collect() {

        lifecycleScope(activity = this, method = {

            editProfilePetViewModel.editProfilePetMutableStateFlow.collect { editProfilePetIntent ->

                EditProfilePetIntentConfig.editProfilePetSelect(editProfilePetIntent = editProfilePetIntent)
            }
        })
    }

    override fun view() {

        spiceArrayList.clear()
        spiceArrayList.addAll(ArrayListUtil.spiceArrayList(activity = this))

        spiceAdapter = SpiceAdapter(activity = this, spiceArrayList = spiceArrayList)

        editProfilePetBinding.apply {

            spiceSpinner.let { spinner ->

                spinner.adapter = spiceAdapter

                spinner.onItemSelectedListener = SpiceSpinnerListener().apply {

                    spiceSpinnerCallBack = object : SpiceSpinnerCallBack {

                        override fun position(position: Int) {

                        }
                    }
                }

                spinner.setSelection(positionSpice())
            }
        }
    }

    private fun positionSpice() = ArrayListUtil.indexSpice(
        activity = this@EditProfilePetActivity,
        id = this@EditProfilePetActivity.editProfilePetViewModel.pet.spice.id
    )
}