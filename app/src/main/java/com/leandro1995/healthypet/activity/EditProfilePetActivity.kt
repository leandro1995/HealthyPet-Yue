package com.leandro1995.healthypet.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.adapter.SpiceAdapter
import com.leandro1995.healthypet.component.config.callback.ImageSelectorComponentCallBack
import com.leandro1995.healthypet.component.config.callback.SexSelectionComponentCallBack
import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.config.callback.intent.EditProfilePetIntentCallBack
import com.leandro1995.healthypet.config.callback.spinner.SpiceSpinnerCallBack
import com.leandro1995.healthypet.config.listener.SpiceSpinnerListener
import com.leandro1995.healthypet.databinding.ActivityEditProfilePetBinding
import com.leandro1995.healthypet.extension.dateFormat
import com.leandro1995.healthypet.extension.lifecycleScope
import com.leandro1995.healthypet.extension.putPet
import com.leandro1995.healthypet.intent.config.EditProfilePetIntentConfig
import com.leandro1995.healthypet.model.design.Calendar
import com.leandro1995.healthypet.model.design.Message
import com.leandro1995.healthypet.model.entity.Spice
import com.leandro1995.healthypet.util.ArrayListUtil
import com.leandro1995.healthypet.util.DesignUtil
import com.leandro1995.healthypet.util.DialogUtil
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

                            this@EditProfilePetActivity.editProfilePetViewModel.pet.spice =
                                spiceArrayList[position]
                        }
                    }
                }

                spinner.setSelection(positionSpice())

                imageSelectorComponent.imageSelectorComponentCallBack =
                    object : ImageSelectorComponentCallBack {
                        override fun photoUrl(url: String) {

                            this@EditProfilePetActivity.editProfilePetViewModel.pet.photoUrl = url
                        }
                    }

                sexSelectionComponent.sexSelectionComponentCallBack =
                    object : SexSelectionComponentCallBack {
                        override fun isSelectSex(isSex: Boolean) {

                            this@EditProfilePetActivity.editProfilePetViewModel.pet.isSex = isSex
                        }
                    }
            }
        }
    }

    override fun datePickerDialog(calendar: Calendar) {

        DialogUtil.datePickerDialog(activity = this, calendar = calendar) { dateLong ->

            editProfilePetBinding.dateText.text =
                dateLong.dateFormat(format = Setting.DATE_FORMAT_ONE)
        }
    }

    override fun messageErrorDialog(message: Message) {

        DialogUtil.messageDialog(activity = this, message = message)
    }

    override fun completeRegistration() {

        startActivity(Intent(this, ToCompleteActivity::class.java).apply {

            putExtra(Setting.CODE_MESSAGE_PUT, Setting.UPDATE_COMPLETE_MESSAGE_CODE)
        })
    }

    private fun positionSpice() = ArrayListUtil.indexSpice(
        activity = this@EditProfilePetActivity,
        id = this@EditProfilePetActivity.editProfilePetViewModel.pet.spice.id
    )
}