package com.leandro1995.healthypet.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.adapter.TypeInjectionCheckedAdapter
import com.leandro1995.healthypet.config.Setting
import com.leandro1995.healthypet.config.callback.intent.RegisterInjectionIntentCallBack
import com.leandro1995.healthypet.databinding.ActivityRegisterInjectionBinding
import com.leandro1995.healthypet.extension.lifecycleScope
import com.leandro1995.healthypet.intent.config.RegisterInjectionIntentConfig
import com.leandro1995.healthypet.model.design.TypeInjectionChecked
import com.leandro1995.healthypet.util.ArrayListUtil
import com.leandro1995.healthypet.util.DesignUtil
import com.leandro1995.healthypet.viewmodel.RegisterInjectionViewModel

class RegisterInjectionActivity : AppCompatActivity(), RegisterInjectionIntentCallBack {

    private lateinit var registerInjectionBinding: ActivityRegisterInjectionBinding

    private val registerInjectionViewModel by viewModels<RegisterInjectionViewModel>()

    private lateinit var typeInjectionCheckedAdapter: TypeInjectionCheckedAdapter

    private val typeInjectionCheckedArrayList = arrayListOf<TypeInjectionChecked>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        RegisterInjectionIntentConfig.instance(registerInjectionIntentCallBack = this)

        registerInjectionBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_register_injection)

        registerInjectionBinding.registerInjectionViewModel = registerInjectionViewModel

        materialToolbar()
        collect()
    }

    private fun materialToolbar() {

        DesignUtil.materialToolbar(activity = this,
            materialToolbar = registerInjectionBinding.appBar.toolbar,
            idTitle = R.string.register_injection_text_title,
            isArrow = true,
            method = { finish() })
    }

    private fun collect() {

        lifecycleScope(activity = this, method = {

            registerInjectionViewModel.registerInjectionMutableSateFlow.collect { registerInjectionIntent ->

                RegisterInjectionIntentConfig.registerInjectionSelect(registerInjectionIntent = registerInjectionIntent)
            }
        })
    }

    override fun view() {

        typeInjectionCheckedArrayList.clear()
        typeInjectionCheckedArrayList.addAll(ArrayListUtil.typeInjectionCheckedArrayList(activity = this))

        typeInjectionCheckedAdapter = TypeInjectionCheckedAdapter()

        registerInjectionBinding.apply {

            typeInjectionRecycler.let { recyclerView ->

                recyclerView.layoutManager =
                    GridLayoutManager(this@RegisterInjectionActivity, Setting.GRID_LAYOUT_TWO)
                recyclerView.adapter = typeInjectionCheckedAdapter
            }
        }

        typeInjectionCheckedAdapter.submitList(typeInjectionCheckedArrayList)
    }
}