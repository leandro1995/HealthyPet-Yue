package com.leandro1995.healthypet.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.config.callback.intent.DetailInjectionIntentCallBack
import com.leandro1995.healthypet.databinding.ActivityDetailInjectionBinding
import com.leandro1995.healthypet.extension.lifecycleScope
import com.leandro1995.healthypet.intent.config.DetailInjectionIntentConfig
import com.leandro1995.healthypet.viewmodel.DetailInjectionViewModel

class DetailInjectionActivity : AppCompatActivity(), DetailInjectionIntentCallBack {

    private lateinit var detailInjectionBinding: ActivityDetailInjectionBinding

    private val detailInjectionViewModel by viewModels<DetailInjectionViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DetailInjectionIntentConfig.instance(detailInjectionIntentCallBack = this)

        detailInjectionBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_detail_injection)

        detailInjectionBinding.detailInjectionViewModel = detailInjectionViewModel

        collect()
    }

    private fun collect() {

        lifecycleScope(activity = this, method = {

            detailInjectionViewModel.detailInjectionMutableStateFlow.collect { detailInjectionIntent ->

                DetailInjectionIntentConfig.detailInjectionSelect(detailInjectionIntent = detailInjectionIntent)
            }
        })
    }

    override fun view() {

    }
}