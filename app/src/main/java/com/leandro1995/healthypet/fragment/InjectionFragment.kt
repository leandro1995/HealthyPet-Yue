package com.leandro1995.healthypet.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.leandro1995.healthypet.R
import com.leandro1995.healthypet.config.callback.intent.InjectionIntentCallBack
import com.leandro1995.healthypet.databinding.FragmentInjectionBinding
import com.leandro1995.healthypet.extension.viewLifecycleOwner
import com.leandro1995.healthypet.intent.config.InjectionIntentConfig
import com.leandro1995.healthypet.util.DesignUtil
import com.leandro1995.healthypet.viewmodel.InjectionViewModel

class InjectionFragment : Fragment(), InjectionIntentCallBack {

    private lateinit var injectionBinding: FragmentInjectionBinding

    private val injectionViewModel by viewModels<InjectionViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        InjectionIntentConfig.instance(injectionIntentCallBack = this)

        injectionBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_injection, container, false)

        injectionBinding.injectionViewModel = injectionViewModel

        materialToolBar()
        collect()

        return injectionBinding.root
    }

    private fun collect() {

        viewLifecycleOwner(fragment = this, method = {

            injectionViewModel.injectionMutableStateFlow.collect { injectionIntent ->

                InjectionIntentConfig.injectionSelect(injectionIntent = injectionIntent)
            }
        })
    }

    private fun materialToolBar() {

        DesignUtil.materialToolbar(
            activity = requireActivity(),
            materialToolbar = injectionBinding.appBar.toolbar,
            idTitle = R.string.injection_text_title
        )
    }

    override fun view() {

    }

    override fun registerInjection(activity: Activity) {

        startActivity(Intent(requireActivity(), activity::class.java))
    }
}