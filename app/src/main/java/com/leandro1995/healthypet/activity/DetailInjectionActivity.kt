package com.leandro1995.healthypet.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.config.callback.intent.DetailInjectionIntentCallBack
import com.leandro1995.healthypet.databinding.ActivityDetailInjectionBinding
import com.leandro1995.healthypet.extension.lifecycleScope
import com.leandro1995.healthypet.extension.putInjection
import com.leandro1995.healthypet.intent.config.DetailInjectionIntentConfig
import com.leandro1995.healthypet.model.entity.Injection
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

        putExtra()
        collect()
    }

    private fun putExtra() {

        detailInjectionViewModel.injection = (Setting.INJECTION_PUT putInjection this)!!
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

    override fun injectionStatus(isStatus: Boolean, injection: Injection) {

        setResult(Activity.RESULT_OK, Intent().apply {

            putExtra(Setting.BOOLEAN_PUT, isStatus)
            putExtra(Setting.INJECTION_PUT, injection)
        })
        finish()
    }
}