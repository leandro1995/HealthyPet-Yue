package com.leandro1995.healthypet.activity

import android.app.Activity
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
import com.leandro1995.healthypet.config.callback.intent.RegisterPetIntentCallBack
import com.leandro1995.healthypet.config.callback.spinner.SpiceSpinnerCallBack
import com.leandro1995.healthypet.config.listener.SpiceSpinnerListener
import com.leandro1995.healthypet.databinding.ActivityRegisterPetBinding
import com.leandro1995.healthypet.extension.dateFormat
import com.leandro1995.healthypet.extension.lifecycleScope
import com.leandro1995.healthypet.intent.config.RegisterPetIntentConfig
import com.leandro1995.healthypet.model.design.Calendar
import com.leandro1995.healthypet.model.design.Message
import com.leandro1995.healthypet.model.entity.Spice
import com.leandro1995.healthypet.util.ActivityUtil
import com.leandro1995.healthypet.util.ArrayListUtil
import com.leandro1995.healthypet.util.DesignUtil
import com.leandro1995.healthypet.util.DialogUtil
import com.leandro1995.healthypet.viewmodel.RegisterPetViewModel

class RegisterPetActivity : AppCompatActivity(), RegisterPetIntentCallBack {

    private lateinit var registerPetBinding: ActivityRegisterPetBinding

    private val registerPetViewModel by viewModels<RegisterPetViewModel>()

    private lateinit var spiceAdapter: SpiceAdapter

    private val spiceArrayList = arrayListOf<Spice>()

    private val resultLauncher =
        ActivityUtil.activityResultLauncher(activity = this) {

            setResult(Activity.RESULT_OK, Intent().apply {

                putExtra(Setting.PET_PUT, registerPetViewModel.pet)
            })
            finish()
        }

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

        spiceArrayList.clear()
        spiceArrayList.addAll(ArrayListUtil.spiceArrayList(activity = this))

        spiceAdapter = SpiceAdapter(activity = this, spiceArrayList = spiceArrayList)

        registerPetBinding.apply {

            spiceSpinner.let { spinner ->

                spinner.adapter = spiceAdapter

                spinner.onItemSelectedListener = SpiceSpinnerListener().apply {

                    spiceSpinnerCallBack = object : SpiceSpinnerCallBack {

                        override fun position(position: Int) {

                            this@RegisterPetActivity.registerPetViewModel.pet.spice =
                                spiceArrayList[position]
                        }
                    }
                }
            }

            imageSelectorComponent.imageSelectorComponentCallBack =
                object : ImageSelectorComponentCallBack {
                    override fun photoUrl(url: String) {

                        this@RegisterPetActivity.registerPetViewModel.pet.photoUrl = url
                    }
                }

            sexSelectionComponent.sexSelectionComponentCallBack =
                object : SexSelectionComponentCallBack {
                    override fun isSelectSex(isSex: Boolean) {

                        this@RegisterPetActivity.registerPetViewModel.pet.isSex = isSex
                    }
                }
        }
    }

    override fun datePickerDialog(calendar: Calendar) {

        DialogUtil.datePickerDialog(activity = this, calendar = calendar) { dateLong ->

            registerPetBinding.dateText.text = dateLong.dateFormat(format = Setting.DATE_FORMAT_ONE)
        }
    }

    override fun messageErrorDialog(message: Message) {

        DialogUtil.messageDialog(activity = this, message = message)
    }

    override fun completeRegistration() {

        resultLauncher.launch(Intent(this, ToCompleteActivity::class.java).apply {

            putExtra(Setting.CODE_MESSAGE_PUT, Setting.TO_COMPLETE_MESSAGE_CODE)
        })
    }
}