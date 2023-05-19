package com.leandro1995.healthypet.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.databinding.ActivityListPetBinding
import com.leandro1995.healthypet.util.DesignUtil

class ListPetActivity : AppCompatActivity() {

    private lateinit var listPetBinding: ActivityListPetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        listPetBinding = DataBindingUtil.setContentView(this, R.layout.activity_list_pet)

        materialToolbar()
    }

    private fun materialToolbar() {

        DesignUtil.materialToolbar(
            activity = this,
            materialToolbar = listPetBinding.appBar.toolbar,
            idTitle = R.string.app_name
        )
    }
}