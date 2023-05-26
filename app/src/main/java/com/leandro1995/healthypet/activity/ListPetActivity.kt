package com.leandro1995.healthypet.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.config.callback.intent.ListPetIntentCallBack
import com.leandro1995.healthypet.databinding.ActivityListPetBinding
import com.leandro1995.healthypet.extension.lifecycleScope
import com.leandro1995.healthypet.extension.putPet
import com.leandro1995.healthypet.extension.putPetArrayList
import com.leandro1995.healthypet.intent.config.ListPetIntentConfig
import com.leandro1995.healthypet.model.entity.Pet
import com.leandro1995.healthypet.util.ActivityUtil
import com.leandro1995.healthypet.util.DesignUtil
import com.leandro1995.healthypet.viewmodel.ListPetViewModel

class ListPetActivity : AppCompatActivity(), ListPetIntentCallBack {

    private lateinit var listPetBinding: ActivityListPetBinding

    private val listPetViewModel by viewModels<ListPetViewModel>()

    private val petArrayList = arrayListOf<Pet>()

    private val resultLauncher =
        ActivityUtil.activityResultLauncher(activity = this) { resultData ->

            petArrayList.add((resultData putPet Setting.PET_PUT)!!)

            listPetBinding.petListComponent.petArrayList(petArrayList = petArrayList)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ListPetIntentConfig.instance(listPetIntentCallBack = this)

        listPetBinding = DataBindingUtil.setContentView(this, R.layout.activity_list_pet)
        listPetBinding.listPetViewModel = listPetViewModel

        putExtra()
        materialToolbar()
        collect()
    }

    private fun putExtra() {

        petArrayList.clear()
        petArrayList.addAll((Setting.PET_ARRAY_LIST_PUT putPetArrayList this)!!)
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

        listPetBinding.petListComponent.petArrayList(petArrayList = petArrayList)
    }

    override fun registerPetActivity(activity: Activity) {

        resultLauncher.launch(Intent(this, activity::class.java))
    }
}