package com.leandro1995.healthypet.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.config.callback.intent.ListPetIntentCallBack
import com.leandro1995.healthypet.databinding.ActivityListPetBinding
import com.leandro1995.healthypet.extension.lifecycleScope
import com.leandro1995.healthypet.intent.config.ListPetIntentConfig
import com.leandro1995.healthypet.util.DesignUtil
import com.leandro1995.healthypet.viewmodel.ListPetViewModel

class ListPetActivity : AppCompatActivity(), ListPetIntentCallBack {

    private lateinit var listPetBinding: ActivityListPetBinding

    private val listPetViewModel by viewModels<ListPetViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ListPetIntentConfig.instance(listPetIntentCallBack = this)

        listPetBinding = DataBindingUtil.setContentView(this, R.layout.activity_list_pet)
        listPetBinding.listPetViewModel = listPetViewModel

        materialToolbar()
        collect()
    }

    private fun materialToolbar() {

        DesignUtil.materialToolbar(
            activity = this,
            materialToolbar = listPetBinding.appBar.toolbar,
            idTitle = R.string.list_pet_text_title
        )
    }

    private fun collect() {

        lifecycleScope(activity = this, method = {

            listPetViewModel.listPetMutableStateFlow.collect { listPetIntent ->

                ListPetIntentConfig.listPetSelect(listPetIntent = listPetIntent)
            }
        })
    }

    override fun view() {

    }

    override fun registerPetActivity(activity: Activity) {

        startActivity(Intent(this, activity::class.java))
    }
}